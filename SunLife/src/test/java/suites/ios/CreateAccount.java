package suites.ios;

import commomUtils.AndroidActions;
import iosPages.HomePage;
import iosPages.LoginPage;
import iosPages.CreateAccountPage;
import iosPages.VerifyMemberPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.IOSBase;
import commomUtils.IOSActions;
import commomUtils.AppiumUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class CreateAccount extends IOSBase {


    @BeforeMethod(alwaysRun = true)
    public void envSetup() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        utils.waitElement(lp.getRegister_now_button());
        lp.getRegister_now_button().click();
        utils.waitElement(vmp.getMemberId_radio_button());
    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new IOSActions(driver).resetApp();
    }

    @Test()
    @Description("Use create account flow using member ID verify method")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsingMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        HomePage hp = new HomePage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "");
        vmp.getVerify_button().click();
        cap.inputTextReturn(cap.getEmailField(), "");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertEquals(hp.getWelcomeMsg().getText(), "");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect terms of use checkbox")
    @Severity(SeverityLevel.NORMAL)
    public void termsBoxNotSelected() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect consent checkbox")
    @Severity(SeverityLevel.NORMAL)
    public void consentBoxNotSelected() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except confirm password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordFieldEmpty() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordFieldEmpty() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except email")
    @Severity(SeverityLevel.NORMAL)
    public void emailFieldEmpty() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with an invalid email")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailInput() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void lessThan_8_64_CharsPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Ga@12");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Ga@12");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password")
    @Severity(SeverityLevel.NORMAL)
    public void noOneUppercaseCharPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one number password")
    @Severity(SeverityLevel.NORMAL)
    public void noOneNumberCharPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@abcd");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@abcd");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one special character")
    @Severity(SeverityLevel.NORMAL)
    public void noSpecialCharPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabea1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabea1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void moreThan_64_CharsPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void with_64_CharsPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertTrue(cap.getCreateAccountButton().isEnabled(), "Create button should be enable when all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields with confirm password different from password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordInputDifferentConfirmPassword() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234G1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Create account using email already used - MemberID")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsedEmailByMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "dorotha@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@123");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.getCreateAccountButton().click();
        Assert.assertTrue(cap.getAccountNotCreated_email_already_inUse().isDisplayed(), "Screen should reset with all fields empty");
    }

    @Test()
    @Description("Does not contain first name")
    @Severity(SeverityLevel.NORMAL)
    public void noFirstNameAsPasswordByMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Shannon@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain last name")
    @Severity(SeverityLevel.NORMAL)
    public void noLastNameAsPasswordByMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Matthews@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain part of email address")
    @Severity(SeverityLevel.NORMAL)
    public void noPartOfEmailAsPasswordByMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextDone(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using . - Member ID")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameByMemberIDDot() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextReturn(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon.Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon.Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using _ - MemberID")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameByMemberID_() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextReturn(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon_Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon_Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using ~ - MemberID")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameByMemberIDSymbol() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextReturn(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon~Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon~Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using space - MemberID")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameByMemberIDSpace() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextReturn(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextReturn(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }


    //---------- SSN ------------//

    @Test()
    @Description("Use create account flow using SSN verify method")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsingSSN() throws FileNotFoundException {
        iosPages.VerifyMemberPage vmp = new iosPages.VerifyMemberPage(driver);
        iosPages.CreateAccountPage cap = new iosPages.CreateAccountPage(driver);
        HomePage hp = new HomePage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "");
        vmp.inputTextDone(vmp.getSsn_text_field(), "");
        vmp.getVerify_button().click();
        cap.inputTextReturn(cap.getEmailField(), "");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertEquals(hp.getWelcomeMsg().getText(), "");
    }

    @Test()
    @Description("Create account using email already used - SSN")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsedEmailBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "dorotha@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@123");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.getCreateAccountButton().click();
        Assert.assertTrue(cap.getAccountNotCreated_email_already_inUse().isDisplayed(), "Screen should reset with all fields empty");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect terms of use checkbox - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void termsBoxNotSelectedBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect consent checkbox - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void consentBoxNotSelectedBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except confirm password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordFieldEmptyBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void passwordFieldEmptyBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except email - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void emailFieldEmptyBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with an invalid email - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailInputBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void lessThan_8_64_CharsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Ga@12");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Ga@12");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");

    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noOneUppercaseCharPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one number password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noOneNumberCharPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@abcd");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@abcd");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one special character - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noSpecialCharPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void moreThan_64_CharsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with 64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void with_64_CharsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertTrue(cap.getCreateAccountButton().isEnabled(), "Create button should be enable when all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields with confirm password different from password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void passwordInputDifferentConfirmPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234G1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Does not contain first name")
    @Severity(SeverityLevel.NORMAL)
    public void noFirstNameAsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Shannon@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain last name")
    @Severity(SeverityLevel.NORMAL)
    public void noLastNameAsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Matthews@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain part of email address")
    @Severity(SeverityLevel.NORMAL)
    public void noPartOfEmailAsPasswordBySSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "gabe@slf.com");
        cap.inputTextReturn(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using . - SSN")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameBySSNDot() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon.Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon.Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using _ - SSN")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameBySSN_() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon_Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon_Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using ~ - SSN")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameBySSNSymbol() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon~Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon~Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using space - SSN")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameBySSNSpace() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextNext(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextNext(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextDone(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextDone(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextReturn(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.inputTextReturn(cap.getPasswordField(), "Shannon Matthews@1234");
        cap.inputTextReturn(cap.getConfirmPasswordField(), "Shannon Matthews@1234");
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }
}
