package suites.ios;

import iosPages.HomePage;
import iosPages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import iosPages.MorePage;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.IOSBase;
import commomUtils.AppiumUtils;
import pages.BottomMenu;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class More extends IOSBase {



    @BeforeClass(alwaysRun = true)
    @Parameters({"email","password"})
    public void envSetup(String email, String password)throws FileNotFoundException{
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        BottomMenu bm = new BottomMenu(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), email);
        lp.inputTextReturn(lp.getLogin_password_text_box(), password);
        utils.waitElement(bm.getMenu_more());
        bm.getMenu_more().click();
        utils.waitElement(new MorePage(driver).getLog_out_button());

    }

    @AfterMethod(alwaysRun = true)
    public void resetting()throws FileNotFoundException {
        new IOSActions(driver).resetApp();
    }

    @Test()
    @Description("Fill out all fields with confirm password different from password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordInputDifferent() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Abc@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordWithExactly64Chars() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        Assert.assertTrue(mp.getSetPasswordButton().isEnabled(), "Set password button should be enabled when all required fields conditions are fulfilled");

    }

    @Test()
    @Description("Fill out all fields and more than 64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordWithMoreThen64Chars()throws FileNotFoundException {
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123Gabe@123");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one special character")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoSpecialChar() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe12345");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Abc@12345");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one number password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoNumber() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@abc");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@abc");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with no at least one uppercase password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordNoUpperCase() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields with less than 8-64 characters password")
    @Severity(SeverityLevel.NORMAL)
    public void passwordLessThan8to64() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@1");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@1");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except old password")
    @Severity(SeverityLevel.NORMAL)
    public void oldPasswordBlank() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except new password")
    @Severity(SeverityLevel.NORMAL)
    public void newPasswordBlank() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Fill out all fields except confirm password")
    @Severity(SeverityLevel.NORMAL)
    public void confirmPasswordBlank() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Gabe@1234");
        mp.inputTextReturn(mp.getNewPasswordField(), "Gabe@1234");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "Set password button should be disabled when all required fields conditions are NOT fulfilled");

    }

    @Test()
    @Description("Input the current password as new")
    @Severity(SeverityLevel.NORMAL)
    public void samePassword() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getChange_password_button().click();
        mp.inputTextReturn(mp.getCurrentPasswordField(), "Dq!123456");
        mp.inputTextReturn(mp.getNewPasswordField(), "Dq!123456");
        mp.inputTextReturn(mp.getConfirmNewPasswordField(), "Dq!123456");
        Assert.assertFalse(mp.getSetPasswordButton().isEnabled(), "User should set a new password sequence");

    }

    @Test()
    @Description("Check presence of first number")
    @Severity(SeverityLevel.NORMAL)
    public void callFirstNumber() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getContact_us_button().click();
        Assert.assertTrue(mp.getContactUSPhoneButton().isDisplayed());

    }

    @Test()
    @Description("Check presence of second number")
    @Severity(SeverityLevel.NORMAL)
    public void callSecondNumber() throws FileNotFoundException{
        MorePage mp = new MorePage(driver);
        mp.getContact_us_button().click();
        Assert.assertTrue(mp.getContactUSPhoneButton().isDisplayed());

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in more screen - Member name")
    @Severity(SeverityLevel.NORMAL)
    public void moreMemberName(HashMap<String, String> data) throws FileNotFoundException {
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId(data.get("mem_first_name")+data.get("mem_last_name"))).getText(), data.get("mem_first_name")+data.get("mem_last_name"));

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in more screen - Member email")
    @Severity(SeverityLevel.NORMAL)
    public void moreMemberEmail(HashMap<String, String> data) throws FileNotFoundException {
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId(data.get("email"))).getText(), data.get("email"));

    }

}
