package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class Login extends AppiumUtils {

    public Login(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id = "com.sunlifeus:id/register-button")
    @iOSXCUITFindBy(accessibility = "register-button")
    private WebElement register_now_button;
    @AndroidFindBy(id = "com.sunlifeus:id/login-email-field")
    @iOSXCUITFindBy(accessibility = "Email address Enter email address")
    private WebElement login_email_address_field;
    @AndroidFindBy(id = "com.sunlifeus:id/login-password-field")
    @iOSXCUITFindBy(accessibility = "Password Enter password")
    private WebElement login_password_field;
    @AndroidFindBy(id = "com.sunlifeus:id/login-forgot-password-button")
    @iOSXCUITFindBy(accessibility = "login-forgot-password-button")
    private WebElement forgot_password_button;
    @AndroidFindBy(id = "com.sunlifeus:id/login-button")
    @iOSXCUITFindBy(accessibility = "login-button")
    private WebElement login_button;
    @iOSXCUITFindBy(accessibility = "terms and conditions")
    private WebElement terms_conditions_link;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Login Failed')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login Failed\"]")
    private WebElement loginFailedModalTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'The email and password combination you have provided is not correct.')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The email and password combination you have provided is not correct.\"]")
    private WebElement loginFailedModalText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'OK')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"OK\"])[2]")
    private WebElement loginFailedModalOK;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Reset Password')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Reset Password\"])[2]")
    private WebElement loginFailedModalResetPassword;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Too many failed login attempts')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Too many failed login attempts\"]")
    private WebElement login_failed_too_many_attempts_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please try again after 30 mins')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please try again after 30 mins\"]")
    private WebElement login_failed_too_many_attempts_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'OK')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"OK\"])[2]")
    private WebElement login_failed_too_many_attempts_ok;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Reset Password')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Reset Password\"])[2]")
    private WebElement login_failed_too_many_attempts_resetPassword;

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
}
