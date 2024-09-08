package iosPages;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class CreateAccountPage extends IOSActions {

    IOSDriver driver;

    public CreateAccountPage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    ///////ELEMENTS///////

    @iOSXCUITFindBy(accessibility = "Email Address* Enter email address")
    private WebElement emailField;
    @iOSXCUITFindBy(accessibility = "Password* Create a secure password that does not include all or part of your name or username. Enter new password")
    private WebElement passwordField;
    @iOSXCUITFindBy(accessibility = "Confirm password* Confirm new password")
    private WebElement confirmPasswordField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uDB80\uDD31\"])[2]")
    private WebElement agreeConsentNDisclosureCheckbox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uDB80\uDD31\"])[1]")
    private WebElement agreeTermsCheckbox;
    @iOSXCUITFindBy(accessibility = "create-account-button")
    private WebElement createAccountButton;
    @iOSXCUITFindBy(accessibility = "The account was not created")
    WebElement accountNotCreated_email_already_inUse;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Okay\"])[3]")
    WebElement accountNotCreated_email_already_inUse_okay_button;

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

    public WebElement getAccountNotCreated_email_already_inUse() {
        return accountNotCreated_email_already_inUse;
    }

    public WebElement getAccountNotCreated_email_already_inUse_okay_button() {
        return accountNotCreated_email_already_inUse_okay_button;
    }
}
