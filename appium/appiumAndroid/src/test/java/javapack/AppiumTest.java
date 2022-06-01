package javapack;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import javapack.pages.base;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AppiumTest extends base {


    public AppiumTest() throws MalformedURLException, InterruptedException {
    }

    AndroidDriver<AndroidElement> driver = capabilities();

    @BeforeClass
    public void setup() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void accessProductsPage(){
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Gabriel");
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Assert.assertEquals(driver.currentActivity(),".AllProductsActivity");

    }
}