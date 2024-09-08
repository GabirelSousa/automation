package commomUtils;

import androidPages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class AndroidActions extends AppiumUtils {

    AndroidDriver driver;


    public AndroidActions(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
    }

    public void inputTextAndroid(WebElement element, String input) {
        tap(element);
        new Actions(driver).sendKeys(input).perform();
        driver.hideKeyboard();
    }

    public void resetApp() {
        driver.executeScript("mobile: clearApp", Map.ofEntries(Map.entry("appId", "com.sunlifeus")));
        driver.executeScript("mobile: activateApp", Map.ofEntries(Map.entry("appId", "com.sunlifeus")));
    }

    public void changeViewAndroid() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                driver.context(contextName);
        }
    }

    public void swipeDown() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"));
        Thread.sleep(1000);
    }

    public void swipeUp() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(1)"));
        Thread.sleep(1000);
    }


}
