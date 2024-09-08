package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class BottomMenu extends AppiumUtils {
    public BottomMenu(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Home\"]")
    @iOSXCUITFindBy(accessibility = "Home, tab, 1 of 5")
    private WebElement menu_home;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Find a Dentist\"]")
    @iOSXCUITFindBy(accessibility = "Find a Dentist, tab, 2 of 5")
    private WebElement menu_fad;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"ID Card\"]")
    @iOSXCUITFindBy(accessibility = "ID Card, tab, 3 of 5")
    private WebElement menu_digital_id;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View Claims\"]")
    @iOSXCUITFindBy(accessibility = "View Claims, tab, 4 of 5")
    private WebElement menu_view_claims;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"More\"]")
    @iOSXCUITFindBy(accessibility = "More, tab, 5 of 5")
    private WebElement menu_more;

    public WebElement getMenu_home() {
        return menu_home;
    }

    public WebElement getMenu_fad() {
        return menu_fad;
    }

    public WebElement getMenu_digital_id() {
        return menu_digital_id;
    }

    public WebElement getMenu_view_claims() {
        return menu_view_claims;
    }

    public WebElement getMenu_more() {
        return menu_more;
    }
}
