package suites.android;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import androidPages.ForgotPasswordPage;
import androidPages.HomePage;
import androidPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AndroidBase;
import commomUtils.AndroidActions;
import commomUtils.AppiumUtils;


import java.io.FileNotFoundException;
import java.util.HashMap;

public class Login extends AndroidBase {


    @BeforeMethod(alwaysRun = true)
    public void envSetup() throws FileNotFoundException {
        new AppiumUtils(driver).waitElement(new LoginPage(driver).getLogin_email_address_field());
    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new AndroidActions(driver).resetApp();
    }

    @Test(dataProvider = "getData", groups = {"PROD","QAR","SMOKE"})
    public void login(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), data.get("email"));
        lp.inputTextAndroid(lp.getLogin_password_field(), data.get("password"));
        lp.getLogin_button().click();
        new AppiumUtils(driver).waitElement(hp.getWelcomeMsg());
        Assert.assertEquals(hp.getWelcomeMsg().getText(), STR."Welcome,\n\{data.get("mem_first_name")} \{data.get("mem_last_name")}", "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with invalid format email")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginInvalidEmailInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), "gabe");
        lp.inputTextAndroid(lp.getLogin_password_field(), data.get("password"));
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when email field has a invalid format");

    }

    @Test()
    @Description("Try to access app with wrong password")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginWrongPasswordInput() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), "dorotha@slf.com");
        lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
        lp.getLogin_button().click();
        Assert.assertTrue(lp.getLoginFailedModalText().isDisplayed(), "Error modal should pop up");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with empty email field")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginEmptyEmailInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextAndroid(lp.getLogin_password_field(), data.get("password"));
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when all required fields are not fill");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with empty password field")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginEmptyPasswordInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), data.get("email"));
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when all required fields are not fill");

    }

    @Test()
    @Description("Check failed login modal closes pressing OK button")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginFailedModalCloseOkButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), "gabe@slf.com");
        lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
        lp.getLogin_button().click();
        lp.getLoginFailedModalOK().click();
        Assert.assertTrue(lp.getLogin_email_address_field().isDisplayed());

    }

    @Test(groups = {"PROD","QAR"})
    @Description("Check failed login modal takes user to reset password screen")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginFailedModalResetPassword() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        lp.inputTextAndroid(lp.getLogin_email_address_field(), "gabe@slf.com");
        lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
        lp.getLogin_button().click();
        lp.getLoginFailedModalResetPassword().click();
        Assert.assertTrue(fpp.getInstructionsText().isDisplayed());

    }

    @Test(groups = {"PROD","QAR"})
    @Description("Check too many attempts modal shows up")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsModal() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        for (int x = 0; x <= 2; x++) {
            lp.inputTextAndroid(lp.getLogin_email_address_field(), "prod-noriega@sl.com");
            lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
            lp.getLogin_button().click();
            lp.getLoginFailedModalOK().click();
        }
        Assert.assertTrue(lp.getLogin_failed_too_many_attempts_text().isDisplayed());
    }

    @Test()
    @Description("Check too many attempts modal OK button dismiss modal")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsOkButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        for (int x = 0; x <= 2; x++) {
            lp.inputTextAndroid(lp.getLogin_email_address_field(), "cyntia@appstore.com");
            lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
            lp.getLogin_button().click();
            lp.getLoginFailedModalOK().click();
        }
        lp.getLogin_failed_too_many_attempts_ok().click();
        Assert.assertTrue(lp.getLogin_email_address_field().isDisplayed());
    }

    @Test(groups = {"PROD","QAR"})
    @Description("Check too many attempts modal reset password button takes user to forgot password screen")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsResetPasswordButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        for (int x = 0; x <= 2; x++) {
            lp.inputTextAndroid(lp.getLogin_email_address_field(), "karen+spouse+kids@prod.com");
            lp.inputTextAndroid(lp.getLogin_password_field(), "123123");
            lp.getLogin_button().click();
            lp.getLoginFailedModalOK().click();
        }
        lp.getLogin_failed_too_many_attemp_resetPassword().click();
        new AppiumUtils(driver).waitElement(fpp.getEmailField());
        Assert.assertTrue(fpp.getEmailField().isDisplayed());
    }
}
