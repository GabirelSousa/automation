package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class LoginPage extends AndroidActions {

    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.sunlifeus:id/register-button")
    private WebElement register_now_button;
    @AndroidFindBy(id = "com.sunlifeus:id/login-email-field")
    private WebElement login_email_address_field;
    @AndroidFindBy(id = "com.sunlifeus:id/login-password-field")
    private WebElement login_password_field;
    @AndroidFindBy(id = "com.sunlifeus:id/login-forgot-password-button")
    private WebElement forgot_password_button;
    @AndroidFindBy(id = "com.sunlifeus:id/login-button")
    private WebElement login_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"terms and conditions\"]")
    private WebElement terms_conditions_text;
    private WebElement terms_conditions_link;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Login Failed')]")
    private WebElement loginFailedModalTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'The email and password combination you have provided is not correct.')]")
    private WebElement loginFailedModalText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'OK')]")
    private WebElement loginFailedModalOK;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Reset Password')]")
    private WebElement loginFailedModalResetPassword;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Too many failed login attempts')]")
    private WebElement login_failed_too_many_attempts_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please try again after 30 mins')]")
    private WebElement login_failed_too_many_attempts_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'OK')]")
    private WebElement login_failed_too_many_attempts_ok;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Reset Password')]")
    private WebElement login_failed_too_many_attemp_resetPassword;

    // ----- FORGOT PASSWORD SCREEN ----- //
    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-email-text-field")
    private WebElement forgot_password_email_field;
    @AndroidFindBy(id = "com.sunlifeus:id/forgot-password-reset-button")
    private WebElement forgot_password_submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'If an account with that email exists, you will receive an email with a password reset link within 15 minutes.')]")
    private WebElement forgot_password_confirmationText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Didn’t receive an email?')]")
    private WebElement forgot_password_questionText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Send another link')]")
    private WebElement forgot_password_sendAnotherLink;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Account not found in our records')]")
    private WebElement forgot_password_email_not_found_modal;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Please check the email address and try again')]")
    private WebElement forgot_password_email_not_found_modal_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Try again')]")
    private WebElement forgot_password_email_not_found_modal_tryAgain_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '\uE605')]")
    private WebElement back_button;

    public WebElement getRegister_now_button() {
        return register_now_button;
    }

    public void setRegister_now_button(WebElement register_now_button) {
        this.register_now_button = register_now_button;
    }

    public WebElement getLogin_email_address_field() {
        return login_email_address_field;
    }

    public void setLogin_email_address_field(WebElement login_email_address_field) {
        this.login_email_address_field = login_email_address_field;
    }

    public WebElement getLogin_password_field() {
        return login_password_field;
    }

    public void setLogin_password_field(WebElement login_password_field) {
        this.login_password_field = login_password_field;
    }

    public WebElement getForgot_password_button() {
        return forgot_password_button;
    }

    public void setForgot_password_button(WebElement forgot_password_button) {
        this.forgot_password_button = forgot_password_button;
    }

    public WebElement getLogin_button() {
        return login_button;
    }

    public void setLogin_button(WebElement login_button) {
        this.login_button = login_button;
    }

    public WebElement getTerms_conditions_text() {
        return terms_conditions_text;
    }

    public void setTerms_conditions_text(WebElement terms_conditions_text) {
        this.terms_conditions_text = terms_conditions_text;
    }

    public WebElement getTerms_conditions_link() {
        return terms_conditions_link;
    }

    public void setTerms_conditions_link(WebElement terms_conditions_link) {
        this.terms_conditions_link = terms_conditions_link;
    }

    public WebElement getLoginFailedModalTitle() {
        return loginFailedModalTitle;
    }

    public void setLoginFailedModalTitle(WebElement loginFailedModalTitle) {
        this.loginFailedModalTitle = loginFailedModalTitle;
    }

    public WebElement getLoginFailedModalText() {
        return loginFailedModalText;
    }

    public void setLoginFailedModalText(WebElement loginFailedModalText) {
        this.loginFailedModalText = loginFailedModalText;
    }

    public WebElement getLoginFailedModalOK() {
        return loginFailedModalOK;
    }

    public void setLoginFailedModalOK(WebElement loginFailedModalOK) {
        this.loginFailedModalOK = loginFailedModalOK;
    }

    public WebElement getLoginFailedModalResetPassword() {
        return loginFailedModalResetPassword;
    }

    public void setLoginFailedModalResetPassword(WebElement loginFailedModalResetPassword) {
        this.loginFailedModalResetPassword = loginFailedModalResetPassword;
    }

    public WebElement getLogin_failed_too_many_attempts_title() {
        return login_failed_too_many_attempts_title;
    }

    public void setLogin_failed_too_many_attempts_title(WebElement login_failed_too_many_attempts_title) {
        this.login_failed_too_many_attempts_title = login_failed_too_many_attempts_title;
    }

    public WebElement getLogin_failed_too_many_attempts_text() {
        return login_failed_too_many_attempts_text;
    }

    public void setLogin_failed_too_many_attempts_text(WebElement login_failed_too_many_attempts_text) {
        this.login_failed_too_many_attempts_text = login_failed_too_many_attempts_text;
    }

    public WebElement getLogin_failed_too_many_attempts_ok() {
        return login_failed_too_many_attempts_ok;
    }

    public void setLogin_failed_too_many_attempts_ok(WebElement login_failed_too_many_attempts_ok) {
        this.login_failed_too_many_attempts_ok = login_failed_too_many_attempts_ok;
    }

    public WebElement getLogin_failed_too_many_attemp_resetPassword() {
        return login_failed_too_many_attemp_resetPassword;
    }

    public void setLogin_failed_too_many_attemp_resetPassword(WebElement login_failed_too_many_attemp_resetPassword) {
        this.login_failed_too_many_attemp_resetPassword = login_failed_too_many_attemp_resetPassword;
    }

    public WebElement getForgot_password_email_field() {
        return forgot_password_email_field;
    }

    public void setForgot_password_email_field(WebElement forgot_password_email_field) {
        this.forgot_password_email_field = forgot_password_email_field;
    }

    public WebElement getForgot_password_submitButton() {
        return forgot_password_submitButton;
    }

    public void setForgot_password_submitButton(WebElement forgot_password_submitButton) {
        this.forgot_password_submitButton = forgot_password_submitButton;
    }

    public WebElement getForgot_password_confirmationText() {
        return forgot_password_confirmationText;
    }

    public void setForgot_password_confirmationText(WebElement forgot_password_confirmationText) {
        this.forgot_password_confirmationText = forgot_password_confirmationText;
    }

    public WebElement getForgot_password_questionText() {
        return forgot_password_questionText;
    }

    public void setForgot_password_questionText(WebElement forgot_password_questionText) {
        this.forgot_password_questionText = forgot_password_questionText;
    }

    public WebElement getForgot_password_sendAnotherLink() {
        return forgot_password_sendAnotherLink;
    }

    public void setForgot_password_sendAnotherLink(WebElement forgot_password_sendAnotherLink) {
        this.forgot_password_sendAnotherLink = forgot_password_sendAnotherLink;
    }

    public WebElement getForgot_password_email_not_found_modal() {
        return forgot_password_email_not_found_modal;
    }

    public void setForgot_password_email_not_found_modal(WebElement forgot_password_email_not_found_modal) {
        this.forgot_password_email_not_found_modal = forgot_password_email_not_found_modal;
    }

    public WebElement getForgot_password_email_not_found_modal_text() {
        return forgot_password_email_not_found_modal_text;
    }

    public void setForgot_password_email_not_found_modal_text(WebElement forgot_password_email_not_found_modal_text) {
        this.forgot_password_email_not_found_modal_text = forgot_password_email_not_found_modal_text;
    }

    public WebElement getForgot_password_email_not_found_modal_tryAgain_button() {
        return forgot_password_email_not_found_modal_tryAgain_button;
    }

    public void setForgot_password_email_not_found_modal_tryAgain_button(WebElement forgot_password_email_not_found_modal_tryAgain_button) {
        this.forgot_password_email_not_found_modal_tryAgain_button = forgot_password_email_not_found_modal_tryAgain_button;
    }

    public WebElement getBack_button() {
        return back_button;
    }

    public void setBack_button(WebElement back_button) {
        this.back_button = back_button;
    }
}