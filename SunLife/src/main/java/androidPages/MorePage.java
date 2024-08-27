package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class MorePage extends AndroidActions {
    AndroidDriver driver;

    public MorePage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "*//android.view.ViewGroup/android.widget.TextView[2]")
    private WebElement more_screen_member_name;
    @AndroidFindBy(xpath = "*//android.view.ViewGroup/android.widget.TextView[3]")
    private WebElement getMore_screen_member_email;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Change Password, \uE606\"]")
    WebElement change_password_button;
    @AndroidFindBy(id = "com.sunlifeus:id/more-contact-us-button")
    WebElement contact_us_button;
    @AndroidFindBy(id = "com.sunlifeus:id/more-log-out-button")
    WebElement log_out_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"prepaid dental companies\"]/android.widget.TextView")
    WebElement policyLink;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"\uE605\"]/android.widget.TextView")
    WebElement backButtonChangePassword;
    @AndroidFindBy(id = "com.sunlifeus:id/change-password-password-text-field")
    WebElement currentPasswordField;
    @AndroidFindBy(id = "com.sunlifeus:id/change-password-new-password-text-field")
    WebElement newPasswordField;
    @AndroidFindBy(id = "com.sunlifeus:id/change-password-confirm-password-text-field")
    WebElement ConfirmNewPasswordField;
    @AndroidFindBy(id = "com.sunlifeus:id/change-password-confirm-button")
    WebElement setPasswordButton;
    @AndroidFindBy(id = "com.sunlifeus:id/contact-us-phone-button")
    WebElement contactUSPhoneButton;
    @AndroidFindBy(id = "com.sunlifeus:id/contact-us-tap-to-call-button")
    WebElement contactUsCallButton;

    public WebElement getMore_screen_member_name() {
        return more_screen_member_name;
    }

    public void setMore_screen_member_name(WebElement more_screen_member_name) {
        this.more_screen_member_name = more_screen_member_name;
    }

    public WebElement getGetMore_screen_member_email() {
        return getMore_screen_member_email;
    }

    public void setGetMore_screen_member_email(WebElement getMore_screen_member_email) {
        this.getMore_screen_member_email = getMore_screen_member_email;
    }

    public WebElement getChange_password_button() {
        return change_password_button;
    }

    public void setChange_password_button(WebElement change_password_button) {
        this.change_password_button = change_password_button;
    }

    public WebElement getContact_us_button() {
        return contact_us_button;
    }

    public void setContact_us_button(WebElement contact_us_button) {
        this.contact_us_button = contact_us_button;
    }

    public WebElement getLog_out_button() {
        return log_out_button;
    }

    public void setLog_out_button(WebElement log_out_button) {
        this.log_out_button = log_out_button;
    }

    public WebElement getPolicyLink() {
        return policyLink;
    }

    public void setPolicyLink(WebElement policyLink) {
        this.policyLink = policyLink;
    }

    public WebElement getBackButtonChangePassword() {
        return backButtonChangePassword;
    }

    public void setBackButtonChangePassword(WebElement backButtonChangePassword) {
        this.backButtonChangePassword = backButtonChangePassword;
    }

    public WebElement getCurrentPasswordField() {
        return currentPasswordField;
    }

    public void setCurrentPasswordField(WebElement currentPasswordField) {
        this.currentPasswordField = currentPasswordField;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public void setNewPasswordField(WebElement newPasswordField) {
        this.newPasswordField = newPasswordField;
    }

    public WebElement getConfirmNewPasswordField() {
        return ConfirmNewPasswordField;
    }

    public void setConfirmNewPasswordField(WebElement confirmNewPasswordField) {
        ConfirmNewPasswordField = confirmNewPasswordField;
    }

    public WebElement getSetPasswordButton() {
        return setPasswordButton;
    }

    public void setSetPasswordButton(WebElement setPasswordButton) {
        this.setPasswordButton = setPasswordButton;
    }

    public WebElement getContactUSPhoneButton() {
        return contactUSPhoneButton;
    }

    public void setContactUSPhoneButton(WebElement contactUSPhoneButton) {
        this.contactUSPhoneButton = contactUSPhoneButton;
    }

    public WebElement getContactUsCallButton() {
        return contactUsCallButton;
    }

    public void setContactUsCallButton(WebElement contactUsCallButton) {
        this.contactUsCallButton = contactUsCallButton;
    }
}