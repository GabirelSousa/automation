package iosPages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class ForgotPasswordPage extends IOSActions {

    IOSDriver driver;

    public ForgotPasswordPage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(accessibility = "\uE605")
    WebElement backButton;
    @iOSXCUITFindBy(accessibility = "Email address Enter email address")
    WebElement emailField;
    @iOSXCUITFindBy(accessibility = "forgot-password-reset-button")
    WebElement submitButton;
    @iOSXCUITFindBy(accessibility = "If an account with that email exists, you will receive an email with a password reset link within 15 minutes.")
    WebElement confirmationText;
    @iOSXCUITFindBy(accessibility = "login-button")
    WebElement sendAnotherLink;
    @iOSXCUITFindBy(accessibility = "Account not found in our records")
    WebElement forgot_password_error_modal_title;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Please check the email address and try again\"]")
    WebElement forgot_password_error_modal_text;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Try again\"])[3]")
    WebElement forgot_password_error_modal_tryAgain_button;


    public WebElement getBackButton() {
        return backButton;
    }

    public void setBackButton(WebElement backButton) {
        this.backButton = backButton;
    }

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

    public WebElement getForgot_password_error_modal_title() {
        return forgot_password_error_modal_title;
    }

    public void setForgot_password_error_modal_title(WebElement forgot_password_error_modal_title) {
        this.forgot_password_error_modal_title = forgot_password_error_modal_title;
    }

    public WebElement getForgot_password_error_modal_text() {
        return forgot_password_error_modal_text;
    }

    public void setForgot_password_error_modal_text(WebElement forgot_password_error_modal_text) {
        this.forgot_password_error_modal_text = forgot_password_error_modal_text;
    }

    public WebElement getForgot_password_error_modal_tryAgain_button() {
        return forgot_password_error_modal_tryAgain_button;
    }

    public void setForgot_password_error_modal_tryAgain_button(WebElement forgot_password_error_modal_tryAgain_button) {
        this.forgot_password_error_modal_tryAgain_button = forgot_password_error_modal_tryAgain_button;
    }
}
