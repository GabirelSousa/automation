package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class CreateAccountPage extends AndroidActions {

        AndroidDriver driver;

    public CreateAccountPage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @AndroidFindBy(id = "com.sunlifeus:id/create-account-email-text-field")
    WebElement emailField;
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-password-text-field")
    WebElement passwordField;
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-confirm-password-field")
    WebElement confirmPasswordField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.sunlifeus:id/create-account-terms-check-box Checkbox, unchecked\"]/android.widget.CheckBox")
    WebElement agreeConsentNDisclosureCheckbox;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Electronic Consent and Disclosure\"]")
    WebElement agreeTermsElectronicLink;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.sunlifeus:id/create-account-electronic-check-box Checkbox, unchecked\"]/android.widget.CheckBox")
    WebElement agreeTermsCheckbox;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Terms of Use\"]")
    WebElement agreeTermsLink;
    @AndroidFindBy(id = "com.sunlifeus:id/create-account-button")
    WebElement createAccountButton;
    @AndroidFindBy(xpath = "//*[@text='The account was not created']")
    WebElement accountNotCreated_email_already_inUse;
    @AndroidFindBy(xpath = "//*[@text='Okay']")
    WebElement accountNotCreated_email_already_inUse_okay_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Your account was created successfully, but we couldn't log you in. Please try logging in again.')]")
    WebElement errorModalText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Continue')]")
    WebElement errorModalContinueButton;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getAgreeConsentNDisclosureCheckbox() {
        return agreeConsentNDisclosureCheckbox;
    }

    public WebElement getAgreeTermsElectronicLink() {
        return agreeTermsElectronicLink;
    }

    public WebElement getAgreeTermsCheckbox() {
        return agreeTermsCheckbox;
    }

    public WebElement getAgreeTermsLink() {
        return agreeTermsLink;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public WebElement getAccountNotCreated_email_already_inUse() {
        return accountNotCreated_email_already_inUse;
    }

    public WebElement getAccountNotCreated_email_already_inUse_okay_button() {
        return accountNotCreated_email_already_inUse_okay_button;
    }

    public WebElement getErrorModalText() {
        return errorModalText;
    }

    public WebElement getErrorModalContinueButton() {
        return errorModalContinueButton;
    }
}
