package suites.ios;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import iosPages.ForgotPasswordPage;
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

public class ForgotPassword extends IOSBase {


    @BeforeMethod(alwaysRun = true)
    public void setupEnv() throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        new AppiumUtils(driver).waitElement(lp.getForgot_password_button());
        lp.getForgot_password_button().click();
        new AppiumUtils(driver).waitElement(fpp.getEmailField());

    }

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new IOSActions(driver).resetApp();
    }

    @Test(dataProvider = "getData")
    @Description("Use forget password with valid email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordFlow(HashMap<String, String> data) throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        Assert.assertTrue(fpp.getConfirmationText().isDisplayed(), "User should land at confirmation screen");
    }

    @Test()
    @Description("Use forget password with invalid format email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordFlowWithInvalidEmail() throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), "doroth");
        Assert.assertFalse(fpp.getSubmitButton().isEnabled(), "Submit button should be disabled when email input is invalid");
    }

    @Test()
    @Description("Check forgot password error modal closes when user press try again button")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordCheckErrorModalCloseTryAgainButton() throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), "gab@slf.com");
        fpp.getSubmitButton().click();
        fpp.getForgot_password_error_modal_tryAgain_button().click();
        //Assert.assertFalse(fpp.getT.isDisplayed(), "Error modal should close when user press try again button");
    }

    @Test(dataProvider = "getData")
    @Description("Check user lands at login page when press back from forgot password confirmation screen")
    @Severity(SeverityLevel.NORMAL)
    public void backToLoginScreenAfterConfirmation(HashMap<String, String> data) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        new AppiumUtils(driver).waitElement(fpp.getSendAnotherLink());
        fpp.getBackButton().click();
        Assert.assertTrue(lp.getLogin_email_address_text_box().isDisplayed(), "User should land at Login screen");
    }

    @Test()
    @Description("Check forgot password modal pops up when user inserts a not registered email")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordNotRegisteredEmail() throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), "srini@dq.com");
        fpp.getSubmitButton().click();
        Assert.assertTrue(fpp.getForgot_password_error_modal_title().isDisplayed());
    }

    @Test(dataProvider = "getData")
    @Description("Check a second email is sent when user press 'send another link'")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPasswordSendAnotherLink(HashMap<String, String> data) throws FileNotFoundException {
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.inputTextReturn(fpp.getEmailField(), data.get("email"));
        fpp.getSubmitButton().click();
        fpp.getSendAnotherLink().click();
        System.out.println("This test case must be checked in an email inbox");
    }
}
