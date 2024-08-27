package commomUtils;


import iosPages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class IOSActions extends AppiumUtils {

    IOSDriver driver;

    public IOSActions(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
    }

    public void inputTextReturn(WebElement element, String input) {
        tap(element);
        element.sendKeys(input + Keys.RETURN);
    }

    public void inputTextDone(WebElement element, String input) {
        tap(element);
        new Actions(driver).sendKeys(input).perform();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Done']")).click();
    }

    public void inputTextNext(WebElement element, String input) {
        tap(element);
        new Actions(driver).sendKeys(input).perform();
        driver.hideKeyboard("next");
    }

    public void resetApp() {
        driver.executeScript("mobile: clearApp", Map.ofEntries(Map.entry("bundleId", "com.sunlifeus")));
        driver.executeScript("mobile: activateApp", Map.ofEntries(Map.entry("bundleId", "com.sunlifeus")));
    }

    public void pressBackButton(){
        driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("\uE605")).click();
    }

    public void changeViewIos() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                driver.context(contextName);
        }
    }
}
