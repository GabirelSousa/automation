package iosPages;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class LoginPage extends IOSActions {

    IOSDriver driver;

    public LoginPage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"You must create a mobile account to use this app. Register now OR Email address Password Forgot password? Log in By logging in, you agree to these  terms and conditions Debug Menu\"]/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    private WebElement sunlife_logo;
    @iOSXCUITFindBy(accessibility = "login-title")
    private WebElement login_title_text;
    @iOSXCUITFindBy(accessibility = "register-button")
    private WebElement register_now_button;
    @iOSXCUITFindBy(accessibility = "Email address Enter email address")
    private WebElement login_email_address_text_box;
    @iOSXCUITFindBy(accessibility = "Password Enter password")
    private WebElement login_password_text_box;
    @iOSXCUITFindBy(accessibility = "login-forgot-password-button")
    private WebElement forgot_password_button;
    @iOSXCUITFindBy(accessibility = "login-button")
    private WebElement login_button;
    @iOSXCUITFindBy(accessibility = "By logging in, you agree to these  terms and conditions")
    private WebElement terms_conditions_text;
    @iOSXCUITFindBy(accessibility = "terms and conditions")
    private WebElement terms_conditions_link;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login Failed\"]")
    private WebElement loginFailedModalTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The email and password combination you have provided is not correct.\"]")
    private WebElement loginFailedModalText;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"OK\"])[2]")
    private WebElement loginFailedModalOK;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Reset Password\"])[2]")
    private WebElement loginFailedModalResetPassword;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Too many failed login attempts\"]")
    private WebElement login_failed_too_many_attempts_title;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please try again after 30 mins\"]")
    private WebElement login_failed_too_many_attempts_text;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"OK\"])[2]")
    private WebElement login_failed_too_many_attempts_ok;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Reset Password\"])[2]")
    private WebElement login_failed_too_many_attempts_resetPassword;

    // ----- FORGOT PASSWORD SCREEN ----- //
    @iOSXCUITFindBy(accessibility = "forgot-password-reset-paragraph-text")
    private WebElement forgot_password_instructionsText;
    @iOSXCUITFindBy(accessibility = "Email address Enter email address")
    private WebElement forgot_password_emailField;
    @iOSXCUITFindBy(accessibility = "forgot-password-reset-button")
    private WebElement forgot_password_submitButton;
    @iOSXCUITFindBy(accessibility = "If an account with that email exists, you will receive an email with a password reset link within 15 minutes.")
    private WebElement forgot_password_confirmationText;
    @iOSXCUITFindBy(accessibility = "Didn’t receive an email?")
    private WebElement forgot_password_questionText;
    @iOSXCUITFindBy(accessibility = "login-button")
    private WebElement forgot_password_sendAnotherLink;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Account not found in our records\"]")
    private WebElement forgot_password_email_not_found_modal;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please check the email address and try again\"]")
    private WebElement forgot_password_email_not_found_modal_text;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Try again\"])[3]")
    private WebElement forgot_password_email_not_found_modal_tryAgain_button;
    @iOSXCUITFindBy(accessibility = "\uE605")
    private WebElement back_button;

    public WebElement getSunlife_logo() {
        return sunlife_logo;
    }

    public void setSunlife_logo(WebElement sunlife_logo) {
        this.sunlife_logo = sunlife_logo;
    }

    public WebElement getLogin_title_text() {
        return login_title_text;
    }

    public void setLogin_title_text(WebElement login_title_text) {
        this.login_title_text = login_title_text;
    }

    public WebElement getRegister_now_button() {
        return register_now_button;
    }

    public void setRegister_now_button(WebElement register_now_button) {
        this.register_now_button = register_now_button;
    }

    public WebElement getLogin_email_address_text_box() {
        return login_email_address_text_box;
    }

    public void setLogin_email_address_text_box(WebElement login_email_address_text_box) {
        this.login_email_address_text_box = login_email_address_text_box;
    }

    public WebElement getLogin_password_text_box() {
        return login_password_text_box;
    }

    public void setLogin_password_text_box(WebElement login_password_text_box) {
        this.login_password_text_box = login_password_text_box;
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

    public WebElement getLogin_failed_too_many_attempts_resetPassword() {
        return login_failed_too_many_attempts_resetPassword;
    }

    public void setLogin_failed_too_many_attempts_resetPassword(WebElement login_failed_too_many_attempts_resetPassword) {
        this.login_failed_too_many_attempts_resetPassword = login_failed_too_many_attempts_resetPassword;
    }

    public WebElement getForgot_password_instructionsText() {
        return forgot_password_instructionsText;
    }

    public void setForgot_password_instructionsText(WebElement forgot_password_instructionsText) {
        this.forgot_password_instructionsText = forgot_password_instructionsText;
    }

    public WebElement getForgot_password_emailField() {
        return forgot_password_emailField;
    }

    public void setForgot_password_emailField(WebElement forgot_password_emailField) {
        this.forgot_password_emailField = forgot_password_emailField;
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