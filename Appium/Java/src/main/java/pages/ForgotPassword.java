package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class ForgotPassword extends AppiumUtils {
    public ForgotPassword(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-email-text-field")
    @iOSXCUITFindBy(accessibility = "Email address Enter email address")
    private WebElement emailField;
    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-reset-button")
    @iOSXCUITFindBy(accessibility = "forgot-password-reset-button")
    private WebElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'If an account with that email exists, you will receive an email with a password reset link within 15 minutes.')]")
    @iOSXCUITFindBy(accessibility = "If an account with that email exists, you will receive an email with a password reset link within 15 minutes.")
    private WebElement confirmationText;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Send another link\"]")
    @iOSXCUITFindBy(accessibility = "login-button")
    private WebElement sendAnotherLink;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Account not found in our records')]")
    @iOSXCUITFindBy(accessibility = "Account not found in our records")
    private WebElement error_modal_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Please check the email address and try again')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Please check the email address and try again\"]")
    private WebElement error_modal_text;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Try again\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Try again\"])[3]")
    private WebElement error_modal_tryAgain_button;

    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }

    public WebElement getConfirmationText() {
        return confirmationText;
    }

    public void setConfirmationText(WebElement confirmationText) {
        this.confirmationText = confirmationText;
    }

    public WebElement getSendAnotherLink() {
        return sendAnotherLink;
    }

    public void setSendAnotherLink(WebElement sendAnotherLink) {
        this.sendAnotherLink = sendAnotherLink;
    }

    public WebElement getError_modal_title() {
        return error_modal_title;
    }

    public void setError_modal_title(WebElement error_modal_title) {
        this.error_modal_title = error_modal_title;
    }

    public WebElement getError_modal_text() {
        return error_modal_text;
    }

    public void setError_modal_text(WebElement error_modal_text) {
        this.error_modal_text = error_modal_text;
    }

    public WebElement getError_modal_tryAgain_button() {
        return error_modal_tryAgain_button;
    }

    public void setError_modal_tryAgain_button(WebElement error_modal_tryAgain_button) {
        this.error_modal_tryAgain_button = error_modal_tryAgain_button;
    }
}
