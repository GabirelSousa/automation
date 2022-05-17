package javapack.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class base {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver;

        File app = new File("C:/Users/Gabriel Sousa/Documents/GitHub/automation/appium/appiumAndroid/src/main/java/javapack/data");
        File apk = new File(app, "General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.UDID, "RFCR20BN9VR");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.7:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;
    }

}
