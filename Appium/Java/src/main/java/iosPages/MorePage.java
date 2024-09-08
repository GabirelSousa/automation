package iosPages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class MorePage extends IOSActions {
    IOSDriver driver;

    public MorePage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Change Password \uE606")
    WebElement change_password_button;
    @iOSXCUITFindBy(accessibility = "more-contact-us-button")
    WebElement contact_us_button;
    @iOSXCUITFindBy(accessibility = "more-log-out-button")
    WebElement log_out_button;
    WebElement policyLink;
    @iOSXCUITFindBy(accessibility = "\uE605")
    WebElement backButtonChangePassword;
    @iOSXCUITFindBy(accessibility = "Current Password* Enter Current Password")
    WebElement currentPasswordField;
    @iOSXCUITFindBy(accessibility = "New Password* Enter New Password")
    WebElement newPasswordField;
    @iOSXCUITFindBy(accessibility = "Confirm password* Re-enter New Password")
    WebElement ConfirmNewPasswordField;
    @iOSXCUITFindBy(accessibility = "change-password-confirm-button")
    WebElement setPasswordButton;
    @iOSXCUITFindBy(accessibility = "\uE605")
    WebElement contactUSBackButton;
    @iOSXCUITFindBy(accessibility = "contact-us-phone-button")
    WebElement contactUSPhoneButton;
    @iOSXCUITFindBy(accessibility = "contact-us-tap-to-call-button")
    WebElement contactUsCallButton;

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

    public WebElement getContactUSBackButton() {
        return contactUSBackButton;
    }

    public void setContactUSBackButton(WebElement contactUSBackButton) {
        this.contactUSBackButton = contactUSBackButton;
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
