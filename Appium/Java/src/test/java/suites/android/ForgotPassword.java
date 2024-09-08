package suites.android;

import androidPages.ForgotPasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class ForgotPassword extends AndroidBase {



    @BeforeMethod(alwaysRun = true)
    public void envSetup() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        new AppiumUtils(driver).waitElement(lp.getForgot_password_button());
        lp.getForgot_password_button().click();
        new AppiumUtils(driver).waitElement(fpp.getEmailField());

    }

    @AfterMethod(alwaysRun = true)
    public void resetting()throws FileNotFoundException{
        new AndroidActions(driver).resetApp();
    }

    @Test(dataProvider = "getData")
    @Description("Use forget password with valid email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordFlow(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        new AppiumUtils(driver).waitElement(fpp.getSendAnotherLink());
        Assert.assertTrue(lp.getForgot_password_confirmationText().isDisplayed(), "User should land at confirmation screen");

    }

    @Test(dataProvider = "getData")
    @Description("Use forget password with invalid format email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordFlowWithInvalidEmail(HashMap<String, String> data) throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), "doroth");
        Assert.assertFalse(fpp.getSubmitButton().isEnabled(), "Submit button should be disabled when email input is invalid");

    }

    @Test(dataProvider = "getData")
    @Description("Check forgot password error modal closes when user press try again button")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordCheckErrorModalCloseTryAgainButton(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), "gab@slf.com");
        fpp.getSubmitButton().click();
        fpp.getError_modal_tryAgain_button().click();
        Assert.assertTrue(fpp.getEmailField().isDisplayed(), "Error modal should close when user press try again button");

    }

    @Test(dataProvider = "getData")
    @Description("Check user lands at login page when press back from forgot password confirmation screen")
    @Severity(SeverityLevel.NORMAL)
    public void backToLoginScreenAfterConfirmation(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        new AppiumUtils(driver).waitElement(fpp.getSendAnotherLink());
        driver.navigate().back();
        Assert.assertTrue(lp.getLogin_email_address_field().isDisplayed(), "User should land at Login screen");

    }

    @Test()
    @Description("Check forgot password error modal pops up when user inserts a not registered email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordNotRegisteredEmail()throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), "srini@dq.com");
        fpp.getSubmitButton().click();
        Assert.assertTrue(fpp.getError_modal_title().isDisplayed());
    }

    @Test(dataProvider = "getData")
    @Description("Check a second email is sent when user press 'send another link'")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordSendAnotherLink(HashMap<String, String> data) throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextAndroid(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        new AppiumUtils(driver).waitElement(fpp.getSendAnotherLink());
        fpp.getSendAnotherLink().click();
        System.out.println("This test case must be checked in an email inbox");
    }
}
