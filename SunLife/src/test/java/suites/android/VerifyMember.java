package suites.android;

import androidPages.LoginPage;
import androidPages.VerifyMemberPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AndroidBase;
import commomUtils.AndroidActions;
import commomUtils.AppiumUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class VerifyMember extends AndroidBase {


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
        new AndroidActions(driver).resetApp();
    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, invalid Member ID + valid DOB")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_InvalidMemberID_ValidDob(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "87487348734");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), (data.get("dob")));
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be presented");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, invalid DOB + valid MemberID")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_InvalidDOB_ValidMemberID(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), data.get("memberID"));
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "22222222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be presented");

    }

    @Test()
    @Description("Try to validate member using Member ID option, invalid DOB + invalid MemberID")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_InvalidMemberID_InvalidDOB() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "2222222222");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "22222222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, 99/99/9999 DOB")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateMemberID_DOB_99_99_9999(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), data.get("memberID"));
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "99999999");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, 00/00/0000 DOB")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateMemberID_DOB_00_00_0000(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), data.get("memberID"));
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "00000000");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, empty MemberID")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_EmptyMemberIDField(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), (data.get("dob")));
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using Member ID option, empty DOB")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_EmptyDOBField(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), data.get("memberID"));
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test()
    @Description("Try to validate member using Member ID option, all fields empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateMemberID_AllFieldsEmpty() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid first name")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidFirstNameInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid last name")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidLastNameInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid DOB")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidDOBInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid SSN")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidSSNInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid First + Last")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidFirstLastInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid First + DOB")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidFirstDOBInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid First + SSN")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidFirstSSNInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid Last + DOB")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_LastDOBInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid Last + SSN")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_LastSSNInput(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Invalid");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, invalid DOB + SSN")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_InvalidDOB_SSN_Input(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2222");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, DOB = 00/00/0000")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_DOB_00_00_0000(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "00000000");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, DOB = 99/99/9999")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_DOB_99_99_9999(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "99999999");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, SSN = 0000")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_SSN_0000(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0000");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, SSN = 9999")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_SSN_9999(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "9999");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, insert more than 4 chars on SSN field")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_SSNMoreThan4Chars(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "00000006");
        Assert.assertEquals(vmp.getSsn_text_field().getText().length(), 4, "SSN field should only accept 4 entries");

    }

    @Test()
    @Description("Try to validate member using SSN option, All fields empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_AllFieldsEmpty() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, First name empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_FirstNameFieldEmpty(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, Last name empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_LastNameFieldEmpty(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, DOB empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_DOBFieldEmpty(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0006");
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test(dataProvider = "getData")
    @Description("Try to validate member using SSN option, SSN empty")
    @Severity(SeverityLevel.NORMAL)
    public void tryValidateSSN_SSNEmpty(HashMap<String, String> data) throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), data.get("mem_first_name"));
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), data.get("mem_last_name"));
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), data.get("dob"));
        Assert.assertFalse(vmp.getVerify_button().isEnabled(), "Verify button should not be enabled");

    }

    @Test()
    @Description(" Try to validate member using SSN option, max chars on first name + last name + 99/99/9999 + 9999")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_MaxCharsInput_99_99_9999_9999() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "qewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqwqewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqw");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "qewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqwqewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqw");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "99999999");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "9999");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test()
    @Description("Try to validate member using SSN option, max chars on first name + last name + 00/00/0000 + 0000")
    @Severity(SeverityLevel.MINOR)
    public void tryValidateSSN_MaxCharsInput_00_00_0000_0000() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "qewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqwqewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqw");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "qewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqwqewgefweqfwefqwefqwefqwefqweqweqwefqwefqwefqrgqwregwefefqwefqwefqw");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "00000000");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "0000");
        vmp.getVerify_button().click();
        Assert.assertTrue(vmp.getError_modal_title().isDisplayed(), "Error modal should be displayed");

    }

    @Test()
    @Description("Check the error modal is dismissed when try again is pressed - Member ID option")
    @Severity(SeverityLevel.MINOR)
    public void checkErrorModalClosesTryAgainButtonMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "124213234");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "22222222");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        Assert.assertTrue(vmp.getVerify_button().isDisplayed(), "Error modal should be dismissed");

    }

    @Test()
    @Description("Check the error modal is dismissed when try again is pressed - SSN option")
    @Severity(SeverityLevel.MINOR)
    public void checkErrorModalClosesTryAgainButtonSSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "First");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Last");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2424");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        Assert.assertTrue(vmp.getFirst_name_text_field().isDisplayed(), "Error modal should be dismissed");

    }

    @Test()
    @Description("Press need help to open assistance modal message - member id")
    @Severity(SeverityLevel.MINOR)
    public void needHelpModalMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "123123123123");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "22222222");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        vmp.getVerify_button().click();
        vmp.getError_modal_need_help_button().click();
        Assert.assertTrue(vmp.getAdditional_help_modal_title().isDisplayed(), "Error modal for need help should be displayed");

    }

    @Test()
    @Description("Press need help to open assistance modal message - SSN")
    @Severity(SeverityLevel.MINOR)
    public void needHelpModalSSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "First");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Last");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2424");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        vmp.getVerify_button().click();
        vmp.getError_modal_need_help_button().click();
        Assert.assertTrue(vmp.getAdditional_help_modal_title().isDisplayed(), "Error modal for need help should be displayed");

    }

    @Test()
    @Description("Press OK to dismiss additional help modal message - member id")
    @Severity(SeverityLevel.MINOR)
    public void needHelpModalOkButtonMemberID() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getMemberId_radio_button().click();
        vmp.inputTextAndroid(vmp.getMemberId_text_field(), "123123123123");
        vmp.inputTextAndroid(vmp.getMember_dob_text_field(), "22222222");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        vmp.getVerify_button().click();
        vmp.getError_modal_need_help_button().click();
        vmp.getAdditional_help_ok_button().click();
        Assert.assertTrue(vmp.getMemberId_text_field().isDisplayed(), "Error modal for need help should be dismissed");

    }

    @Test()
    @Description("Press OK to dismiss additional help modal message - SSN")
    @Severity(SeverityLevel.MINOR)
    public void needHelpModalOkButtonSSN() throws FileNotFoundException {
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        vmp.getLastSSN_ratio_button().click();
        vmp.inputTextAndroid(vmp.getFirst_name_text_field(), "First");
        vmp.inputTextAndroid(vmp.getLast_name_text_field(), "Last");
        vmp.inputTextAndroid(vmp.getSsn_Dob_text_field(), "22222222");
        vmp.inputTextAndroid(vmp.getSsn_text_field(), "2424");
        vmp.getVerify_button().click();
        vmp.getError_modal_try_again_button().click();
        vmp.getVerify_button().click();
        vmp.getError_modal_need_help_button().click();
        vmp.getAdditional_help_ok_button().click();
        Assert.assertTrue(vmp.getFirst_name_text_field().isDisplayed(), "Error modal for need help should be dismissed");

    }
}

