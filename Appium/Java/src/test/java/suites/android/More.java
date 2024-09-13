package suites.android;

import androidPages.LoginPage;
import androidPages.MorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.AndroidBase;
import commomUtils.AndroidActions;
import commomUtils.AppiumUtils;
import pages.BottomMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class More extends AndroidBase {

    @BeforeClass(alwaysRun = true)
    @Parameters({"email","password"})
    public void envSetup(String email, String password) throws IOException {
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        BottomMenu bm = new BottomMenu(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextAndroid(lp.getLogin_email_address_field(), email);
        lp.inputTextAndroid(lp.getLogin_password_field(), password);
        lp.getLogin_button().click();
        utils.waitElement(bm.getMenu_more());
        bm.getMenu_more().click();
        utils.waitElement(new MorePage(driver).getLog_out_button());

    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new AndroidActions(driver).resetApp();
    }

//    @Test(dataProvider = "getData", groups = {"PROD","QAR","SMOKE"})
//    @Description("Change the password")
//    @Severity(SeverityLevel.BLOCKER)
//    public void changePassword(HashMap<String, String> data) throws FileNotFoundException{
//        MorePage mp = new MorePage(driver);
//        mp.getChange_password_button().click();
//        mp.inputTextAndroid(mp.getCurrentPasswordField(), data.get("password"));
//        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1234");
//        mp.inputTextAndroid(mp.getConfirmNewPasswordField(),"Gabe@1234");
//        mp.getSetPasswordButton().click();
//        Assert.assertTrue(mp.getConfirmMessageModal().isDisplayed);
//    }
    @Test()
    @Description("Fill out all fields with confirm password different from password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordInputDifferent() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Abc@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordWithExactly64Chars() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        Assert.assertTrue(mp.getSetPasswordButton().isEnabled(), "Set password button should be enabled when all required fields conditions are fulfilled");

    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordWithMoreThen64Chars() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one special character")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoSpecialChar() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe12345");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Abc@12345");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one number password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoNumber() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@abc");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@abc");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoUpperCase() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordLessThan8to64() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@1");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except current password")
    @Severity(SeverityLevel.NORMAL)
    public void oldPasswordBlank() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except new password")
    @Severity(SeverityLevel.NORMAL)
    public void newPasswordBlank() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except confirm password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordBlank() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Input the current password in all fields")
    @Severity(SeverityLevel.NORMAL)
    public void samePassword() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextAndroid(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextAndroid(mp.getNewPasswordField(), "Dq!123456");
        mp.inputTextAndroid(mp.getConfirmNewPasswordField(), "Dq!123456");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test(groups = {"PROD", "QAR"})
    @Description("Call first number")
    @Severity(SeverityLevel.NORMAL)
    public void callFirstNumber() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getContact_us_button().click();
        mp.getContactUsCallButton().click();
        Assert.assertEquals(driver.getCurrentPackage(), "com.google.android.dialer", "User should be taken to dialer phone app with the same number");
        driver.executeScript("mobile: terminateApp", Map.ofEntries(Map.entry("appId", "com.google.android.dialer")));

    }

    @Test(groups = {"PROD", "QAR"})
    @Description("Call second number")
    @Severity(SeverityLevel.NORMAL)
    public void callSecondNumber() throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getContact_us_button().click();
        mp.getContactUSPhoneButton().click();
        Assert.assertEquals(driver.getCurrentPackage(), "com.google.android.dialer", "User should be taken to dialer phone app with the same number");
        driver.executeScript("mobile: terminateApp", Map.ofEntries(Map.entry("appId", "com.google.android.dialer")));

    }

    @Test(dataProvider = "getData", groups = {"PROD", "QAR"})
    @Description("Validate data is matching in more screen - Member name")
    @Severity(SeverityLevel.NORMAL)
    public void moreMemberName(HashMap<String, String> data) throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        Assert.assertEquals(mp.getMore_screen_member_name().getText(), data.get("mem_first_name")+data.get("mem_last_name"));

    }

    @Test(dataProvider = "getData", groups = {"PROD", "QAR"})
    @Description("Validate data is matching in more screen - Member email")
    @Severity(SeverityLevel.NORMAL)
    public void moreMemberEmail(HashMap<String, String> data) throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        Assert.assertEquals(mp.getGetMore_screen_member_email().getText(), data.get("email"));

    }

//✅ User’s details displayed
//✅ Contact us⇒ phone numbers displayed and clickable
//✅ Email clickable on the more tab
}
