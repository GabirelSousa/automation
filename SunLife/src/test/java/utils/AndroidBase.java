package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import commomUtils.AppiumUtils;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class AndroidBase {

    public static AndroidDriver driver;
    static UiAutomator2Options androidOptions = new UiAutomator2Options();

    @BeforeClass(groups = "QAR")
    public void configQAR() throws URISyntaxException, IOException {
        androidOptions.setDeviceName("EMU");
        androidOptions.setAutomationName("UIAutomator2");
        androidOptions.setPlatformName("android");
        androidOptions.setCapability("autoGrantPermissions", true);
        androidOptions.setApp(STR."\{System.getProperty("user.dir")}//src//test//java//resources//qar//app-debug.apk");
        System.out.println("Installing QAR apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), androidOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeClass(groups = "PROD")
    public void configPROD() throws URISyntaxException, MalformedURLException {
        androidOptions.setDeviceName("EMU");
        androidOptions.setAutomationName("UIAutomator2");
        androidOptions.setPlatformName("android");
        androidOptions.setCapability("autoGrantPermissions", true);
        androidOptions.setApp(STR."\{System.getProperty("user.dir")}//src//test//java//resources//prod//app-debug.apk");
        System.out.println("Installing PROD apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), androidOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.terminateApp("com.sunlifeus");
        driver.removeApp("com.sunlifeus");
        driver.quit();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        AppiumUtils utils = new AppiumUtils(driver);
        List<HashMap<String, String>> data = utils.getJsonData(STR."\{System.getProperty("user.dir")}//src//test//java//data//sunlifeData.json");
        return new Object[][]{{data.getFirst()}};
    }


}
