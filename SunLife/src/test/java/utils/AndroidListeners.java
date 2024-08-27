package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class AndroidListeners extends AndroidBase implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment(STR."\{result.getMethod().getMethodName()}_ANDROID", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            Allure.addAttachment(STR."\{result.getMethod().getMethodName()}_ANDROID", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        copyHistory();
        File location = new File(STR."\{System.getProperty("user.dir")}");
        try {
            runCommand(location);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void runCommand(File location) throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(location);
        builder.command("sh", "-c", "allure generate --clean");
        builder.start();
    }

    private void copyHistory() {
        String source = STR."\{System.getProperty("user.dir")}//allure-report//history";
        File srcDir = new File(source);

        String destination = STR."\{System.getProperty("user.dir")}//allure-results//history";
        File dstDir = new File(destination);

        try {
            FileUtils.copyDirectory(srcDir, dstDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

