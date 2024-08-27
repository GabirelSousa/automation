package commomUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class AppiumUtils {

    public AppiumDriver driver;

    public AppiumUtils(AppiumDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<>() {
        });
    }

    public void tap(WebElement element) {
        Point sourceLocation = element.getLocation();
        Dimension sourceSize = element.getSize();
        int centerX = sourceLocation.getX() + sourceSize.getWidth() / 2;
        int centerY = sourceLocation.getY() + sourceSize.getHeight() / 2;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
        element.clear();
    }

    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void handleAlert() {
        try {
            driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert not present");
        }
    }

    public String methodName(){
        return new Object(){}.getClass().getEnclosingMethod().getName();
    }

    public void takeScreenshot(String methodName) {
        Allure.addAttachment(methodName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }

}

