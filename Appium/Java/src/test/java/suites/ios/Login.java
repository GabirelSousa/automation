package suites.ios;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import iosPages.ForgotPasswordPage;
import iosPages.HomePage;
import iosPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.IOSBase;
import commomUtils.AppiumUtils;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Login extends IOSBase {


    @BeforeMethod(alwaysRun = true)
    public void setupEnv() throws FileNotFoundException {
        new AppiumUtils(driver).waitElement(new LoginPage(driver).getLogin_email_address_text_box());

    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new IOSActions(driver).resetApp();
    }

    @Test(dataProvider = "getData")
    public void login(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), data.get("email"));
        lp.inputTextReturn(lp.getLogin_password_text_box(), "password");
        new AppiumUtils(driver).waitElement(hp.getWelcomeMsg());
        Assert.assertEquals(hp.getWelcomeMsg().getText(), STR."Welcome,\n\{data.get("mem_first_name")} \{data.get("mem_last_name")}", "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with invalid format email")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginInvalidEmailInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), "gabe");
        lp.inputTextReturn(lp.getLogin_password_text_box(), "password");
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when email field has a invalid format");

    }

    @Test()
    @Description("Try to access app with wrong password")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginWrongPasswordInput() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), "dorotha@slf.com");
        lp.getLogin_password_text_box().sendKeys("123123");
        Assert.assertFalse(lp.getLoginFailedModalText().isDisplayed(), "Error modal should pop up");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with empty email field")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginEmptyEmailInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextReturn(lp.getLogin_password_text_box(), "password");
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when all required fields are not fill");

    }

    @Test(dataProvider = "getData")
    @Description("Try to access app with empty password field")
    @Severity(SeverityLevel.NORMAL)
    public void tryToLoginEmptyPasswordInput(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), (data.get("email")));
        Assert.assertFalse(lp.getLogin_button().isEnabled(), "Button should be disabled when all required fields are not fill");

    }

    @Test()
    @Description("Check failed login modal closes pressing OK button")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginFailedModalCloseOkButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), "gabe@slf.com");
        lp.getLogin_password_text_box().sendKeys("123123");
        lp.getLogin_button().click();
        lp.getLoginFailedModalOK().click();
        Assert.assertTrue(lp.getLogin_email_address_text_box().isDisplayed());

    }

    @Test()
    @Description("Check failed login modal takes user to reset password screen")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginFailedModalResetPassword() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), "gabe@slf.com");
        lp.getLogin_password_text_box().sendKeys("123123");
        lp.getLoginFailedModalResetPassword().click();
        Assert.assertTrue(fpp.getEmailField().isDisplayed());

    }

    @Test()
    @Description("Check too many attempts modal shows up")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsModal() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        while (!lp.getLogin_failed_too_many_attempts_text().isDisplayed()) {
            lp.inputTextReturn(lp.getLogin_email_address_text_box(), "lewis@slf.com");
            lp.getLogin_password_text_box().sendKeys("123123");
            lp.getLoginFailedModalOK().click();
        }
        Assert.assertTrue(lp.getLogin_failed_too_many_attempts_text().isDisplayed());
    }

    @Test()
    @Description("Check too many attempts modal OK button dismiss modal")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsOkButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        while (!lp.getLogin_failed_too_many_attempts_text().isDisplayed()) {
            lp.inputTextReturn(lp.getLogin_email_address_text_box(), "lewis@slf.com");
            lp.getLogin_password_text_box().sendKeys("123123");
            lp.getLoginFailedModalOK().click();
        }
        lp.getLogin_failed_too_many_attempts_ok().click();
        Assert.assertTrue(lp.getLogin_email_address_text_box().isDisplayed());
    }

    @Test()
    @Description("Check too many attempts modal reset password button takes user to forgot password screen")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTooManyAttemptsResetPasswordButton() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        while (!lp.getLogin_failed_too_many_attempts_text().isDisplayed()) {
            lp.inputTextReturn(lp.getLogin_email_address_text_box(), "lewis@slf.com");
            lp.getLogin_password_text_box().sendKeys("123123");
            lp.getLoginFailedModalOK().click();
        }
        lp.getLogin_failed_too_many_attempts_resetPassword().click();
        Assert.assertTrue(fpp.getEmailField().isDisplayed());
    }
}
