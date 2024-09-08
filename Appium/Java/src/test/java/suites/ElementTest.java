package suites;

import commomUtils.AppiumUtils;
import commomUtils.IOSActions;
import iosPages.VerifyMemberPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.IOSBase;

import java.io.FileNotFoundException;


public class ElementTest extends IOSBase {


    @BeforeMethod
    public void envSetup() throws FileNotFoundException {
        iosPages.LoginPage lp = new iosPages.LoginPage(driver);
        VerifyMemberPage vmp = new VerifyMemberPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        utils.waitElement(lp.getRegister_now_button());
        lp.getRegister_now_button().click();
        utils.waitElement(vmp.getMemberId_radio_button());
    }

    @AfterMethod
    public void resetting() throws FileNotFoundException {
        new IOSActions(driver).resetApp();
    }






}
