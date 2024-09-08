package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import commomUtils.AppiumUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class IOSBase {
    public static IOSDriver driver;
    static XCUITestOptions iosOptions = new XCUITestOptions();

    @BeforeClass(groups = "QAR")
    public void configQAR() throws MalformedURLException, URISyntaxException {
        iosOptions.setDeviceName("iPhone 15");
        iosOptions.setAutomationName("XCUITest");
        iosOptions.setPlatformName("IOS");
        iosOptions.setPlatformVersion("17.2");
        iosOptions.setCapability("useNewWDA", true);
        iosOptions.setCapability("wdaLaunchTimeout", 60000);
        iosOptions.setCapability("wdaConnectionTimeout", 6000);
        iosOptions.setCapability("simpleIsVisibleCheck", true);
        iosOptions.setCapability("autoAcceptAlerts", true);
        iosOptions.setCapability("sendKeyStrategy", "OneByOne");
        iosOptions.setApp(STR."\{System.getProperty("user.dir")}//src//test//java//resources//qar//SunLifeUS.app");
        System.out.println("Installing QAR apk");
        iosOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), iosOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeClass(groups = "PROD")
    public void configProd() throws MalformedURLException, URISyntaxException {
        iosOptions.setDeviceName("iPhone 15");
        iosOptions.setAutomationName("XCUITest");
        iosOptions.setPlatformName("IOS");
        iosOptions.setPlatformVersion("17.2");
        iosOptions.setCapability("useNewWDA", true);
        iosOptions.setCapability("wdaLaunchTimeout", 60000);
        iosOptions.setCapability("wdaConnectionTimeout", 6000);
        iosOptions.setCapability("simpleIsVisibleCheck", true);
        iosOptions.setCapability("autoAcceptAlerts", true);
        iosOptions.setCapability("sendKeyStrategy", "OneByOne");
        iosOptions.setApp(STR."\{System.getProperty("user.dir")}//src//test//java//resources//prod//SunLifeUS.app");
        System.out.println("Installing PROD apk");
        iosOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver = new IOSDriver(new URI("http://127.0.0.99:4723").toURL(), iosOptions);
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
