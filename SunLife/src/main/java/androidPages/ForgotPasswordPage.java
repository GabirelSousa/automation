package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class ForgotPasswordPage extends AndroidActions {

    AndroidDriver driver;

    public ForgotPasswordPage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-reset-paragraph-text")
    private WebElement instructionsText;
    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-email-text-field")
    private WebElement emailField;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Email Address')]")
    private WebElement emailFieldText;
    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-reset-button")
    private WebElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'If an account with that email exists, you will receive an email with a password reset link within 15 minutes.')]")
    private WebElement confirmationText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Didn’t receive an email?')]")
    private WebElement questionText;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Send another link\"]")
    private WebElement sendAnotherLink;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Account not found in our records')]")
    private WebElement error_modal_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Please check the email address and try again')]")
    private WebElement error_modal_text;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Try again\"]")
    private WebElement error_modal_tryAgain_button;

    public WebElement getInstructionsText() {
        return instructionsText;
    }

    public void setInstructionsText(WebElement instructionsText) {
        this.instructionsText = instructionsText;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getEmailFieldText() {
        return emailFieldText;
    }

    public void setEmailFieldText(WebElement emailFieldText) {
        this.emailFieldText = emailFieldText;
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

    public WebElement getQuestionText() {
        return questionText;
    }

    public void setQuestionText(WebElement questionText) {
        this.questionText = questionText;
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
