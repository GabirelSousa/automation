package suites.android;

import androidPages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import androidPages.CreateAccountPage;
import androidPages.LoginPage;
import androidPages.VerifyMemberPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.AndroidBase;
import commomUtils.AndroidActions;
import commomUtils.AppiumUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class CreateAccount extends AndroidBase {


    @BeforeMethod(alwaysRun = true)
    public void envSetup() throws FileNotFoundException, InterruptedException {
        LoginPage lp = new LoginPage(driver);
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        utils.waitElement(lp.getRegister_now_button());
        lp.getRegister_now_button().click();
        utils.waitElement(vmp.getMemberId_radio_button());
    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException, InterruptedException {
        new AndroidActions(driver).resetApp();
    }

    @Test()
    @Description("Use create account flow using member ID verify method")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsingMemberID() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        HomePage hp = new HomePage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "");
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertEquals(hp.getWelcomeMsg().getText(), "");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect terms of use checkbox")
    @Severity(SeverityLevel.NORMAL)
    public void termsBoxNotSelected() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect consent checkbox")
    @Severity(SeverityLevel.NORMAL)
    public void consentBoxNotSelected() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except confirm password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordFieldEmpty() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordFieldEmpty() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except email")
    @Severity(SeverityLevel.NORMAL)
    public void emailFieldEmpty() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");

        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with an invalid email")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailInput() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "gabe");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void lessThan_8_64_CharsPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Ga@12");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Ga@12");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password")
    @Severity(SeverityLevel.NORMAL)
    public void noOneUppercaseCharPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one number password")
    @Severity(SeverityLevel.NORMAL)
    public void noOneNumberCharPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@abcd");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@abcd");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one special character")
    @Severity(SeverityLevel.NORMAL)
    public void noSpecialCharPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabea1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabea1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void moreThan_64_CharsPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void with_64_CharsPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertTrue(cap.getCreateAccountButton().isEnabled(), "Create button should be enable when all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields with confirm password different from password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordInputDifferentConfirmPassword() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234G1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test(dataProvider = "getData")
    @Description("Create account using email already used - MemberID")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsedEmailByMemberIdQar(HashMap<String, String> data) throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), data.get("email"));
        cap.inputTextAndroid(cap.getPasswordField(), "Pass@123");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Pass@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.getCreateAccountButton().click();
        Assert.assertTrue(cap.getAccountNotCreated_email_already_inUse().isDisplayed(), "Error modal message should pop up");
    }


    @Test()
    @Description("Does not contain first name")
    @Severity(SeverityLevel.NORMAL)
    public void noFirstNameAsPasswordByMemberID() throws FileNotFoundException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Shannon@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Shannon@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain last name")
    @Severity(SeverityLevel.NORMAL)
    public void noLastNameAsPasswordByMemberID() throws FileNotFoundException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Matthews@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Matthews@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain part of email address")
    @Severity(SeverityLevel.NORMAL)
    public void noPartOfEmailAsPasswordByMemberID() throws FileNotFoundException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "Email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Email@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Email@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using symbols - Member ID")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameByMemberID() throws FileNotFoundException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "001720006");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "02201975");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        String[] symbols = {".", "_", "~", " "};
        for (String symbol : symbols) {
            cap.inputTextAndroid(cap.getPasswordField(), STR."Shannon\{symbol}Matthews@1234");
            cap.inputTextAndroid(cap.getConfirmPasswordField(), STR."Shannon\{symbol}Matthews@1234");
            Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
        }

    }


    //---------- SSN ------------//

    @Test()
    @Description("Use create account flow using SSN verify method")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsingSSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        HomePage hp = new HomePage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "");
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertEquals(hp.getWelcomeMsg().getText(), "");
    }

    @Test(dataProvider = "getData")
    @Description("Create account using email already used - SSN")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccountUsedEmailBySSN(HashMap<String, String> data) throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), data.get("email"));
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@123");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        cap.getCreateAccountButton().click();
        Assert.assertTrue(cap.getAccountNotCreated_email_already_inUse().isDisplayed(), "Error modal message should pop up");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect terms of use checkbox - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void termsBoxNotSelectedBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields correctly and deselect consent checkbox - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void consentBoxNotSelectedBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except confirm password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordFieldEmptyBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void passwordFieldEmptyBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields except email - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void emailFieldEmptyBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with an invalid email - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailInputBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "gabe");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void lessThan_8_64_CharsPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Ga@12");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Ga@12");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");

    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noOneUppercaseCharPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one number password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noOneNumberCharPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@abcd");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@abcd");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with no at least one special character - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void noSpecialCharPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void moreThan_64_CharsPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Fill out all fields with 64 characters password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void with_64_CharsPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertTrue(cap.getCreateAccountButton().isEnabled(), "Create button should be enable when all required fields conditions are filled");
    }

    @Test()
    @Description("Fill out all fields with confirm password different from password - SSN")
    @Severity(SeverityLevel.NORMAL)
    public void passwordInputDifferentConfirmPasswordBySSN() throws InterruptedException, FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");

        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234G1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disable when all required fields conditions are NOT filled");
    }

    @Test()
    @Description("Does not contain first name")
    @Severity(SeverityLevel.NORMAL)
    public void noFirstNameAsPasswordBySSN() throws FileNotFoundException, InterruptedException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Shannon@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Shannon@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain last name")
    @Severity(SeverityLevel.NORMAL)
    public void noLastNameAsPasswordBySSN() throws FileNotFoundException, InterruptedException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Matthews@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Matthews@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain part of email address")
    @Severity(SeverityLevel.NORMAL)
    public void noPartOfEmailAsPasswordBySSN() throws FileNotFoundException, InterruptedException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "email@slf.com");
        cap.inputTextAndroid(cap.getPasswordField(), "Gabe@1234");
        cap.inputTextAndroid(cap.getConfirmPasswordField(), "Gabe@1234");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
    }

    @Test()
    @Description("Does not contain first name and last name, using symbols - SSN")
    @Severity(SeverityLevel.MINOR)
    public void noFirstNLastNameBySSN() throws FileNotFoundException, InterruptedException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        CreateAccountPage cap = new CreateAccountPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Shannon");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Matthews");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "02201975");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        new AndroidActions(driver).swipeDown();
        new AppiumUtils(driver).waitElement(cap.getEmailField());
        cap.inputTextAndroid(cap.getEmailField(), "Email@slf.com");
        cap.getAgreeConsentNDisclosureCheckbox().click();
        cap.getAgreeTermsCheckbox().click();
        String[] symbols = {".", "_", "~", " "};
        for (String symbol : symbols) {
            cap.inputTextAndroid(cap.getPasswordField(), STR."Shannon\{symbol}Matthews@1234");
            cap.inputTextAndroid(cap.getConfirmPasswordField(), STR."Shannon\{symbol}Matthews@1234");
            Assert.assertFalse(cap.getCreateAccountButton().isEnabled(), "Create button should be disabled when NOT all required fields conditions are filled");
        }

    }

}
