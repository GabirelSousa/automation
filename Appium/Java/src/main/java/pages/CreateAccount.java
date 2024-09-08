package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class CreateAccount extends AppiumUtils {

    public CreateAccount(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility = "Email Address* Enter email address")
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-email-text-field")
    private WebElement emailField;
    @iOSXCUITFindBy(accessibility = "Password* Create a secure password that does not include all or part of your name or username. Enter new password")
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-password-text-field")
    private WebElement passwordField;
    @iOSXCUITFindBy(accessibility = "Confirm password* Confirm new password")
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-confirm-password-field")
    private WebElement confirmPasswordField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uDB80\uDD31\"])[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.sunlifeus:id/create-account-electronic-check-box Checkbox, unchecked\"]/android.widget.CheckBox")
    private WebElement agreeConsentNDisclosureCheckbox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uDB80\uDD31\"])[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.sunlifeus:id/create-account-electronic-check-box Checkbox, unchecked\"]/android.widget.CheckBox")
    private WebElement agreeTermsCheckbox;
    @iOSXCUITFindBy(accessibility = "create-account-button")
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-button")
    private WebElement createAccountButton;

    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(WebElement confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public WebElement getAgreeConsentNDisclosureCheckbox() {
        return agreeConsentNDisclosureCheckbox;
    }

    public void setAgreeConsentNDisclosureCheckbox(WebElement agreeConsentNDisclosureCheckbox) {
        this.agreeConsentNDisclosureCheckbox = agreeConsentNDisclosureCheckbox;
    }

    public WebElement getAgreeTermsCheckbox() {
        return agreeTermsCheckbox;
    }

    public void setAgreeTermsCheckbox(WebElement agreeTermsCheckbox) {
        this.agreeTermsCheckbox = agreeTermsCheckbox;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(WebElement createAccountButton) {
        this.createAccountButton = createAccountButton;
    }
}
