package suites.android;

import commomUtils.AndroidActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import androidPages.CardIDPage;
import androidPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.AndroidBase;
import commomUtils.AppiumUtils;
import pages.BottomMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class CardID extends AndroidBase {

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
        utils.waitElement(bm.getMenu_digital_id());
        bm.getMenu_digital_id().click();
    }

    @Test(dataProvider = "getData", groups = {"PROD", "QAR"})
    @Description("Validate data is matching in idCard screen - Member name")
    @Severity(SeverityLevel.NORMAL)
    public void idCardMemberName(HashMap<String, String> data) throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        Assert.assertEquals(idp.getMember_name().getText(), data.get("mem_first_name")+data.get("mem_last_name"));
    }

    @Test(dataProvider = "getData", groups = {"QAR"})
    @Description("Validate data is matching in idCard screen - Member ID")
    @Severity(SeverityLevel.NORMAL)
    public void idCardMemberID(HashMap<String, String> data) throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        Assert.assertEquals(idp.getMember_id().getText(), data.get("memberID"));
    }

    @Test(dataProvider = "getData", groups = {"PROD"})
    @Description("Validate data is matching in idCard screen - Issued to")
    @Severity(SeverityLevel.NORMAL)
    public void idCardIssueTo(HashMap<String, String> data) throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        Assert.assertEquals(idp.getGroup_name().getText(), data.get("card_issued_to"));
    }

    @Test(dataProvider = "getData", groups = {"PROD"})
    @Description("Validate data is matching in idCard screen - Group ID number")
    @Severity(SeverityLevel.NORMAL)
    public void idCardGroupIdNumber(HashMap<String, String> data) throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        Assert.assertEquals(idp.getGroup_id().getText(), data.get("card_group_id_number"));
    }

    @Test(groups = {"PROD", "QAR"}, priority = 1)
    @Description("Verify share flow is working")
    @Severity(SeverityLevel.CRITICAL)
    public void shareFlowAndroid() throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        idp.getShare_button().click();
        new AndroidActions(driver).changeViewAndroid();
        idp.getPrint_share_option().click();
        utils.waitElement(idp.getPdf_file());
        utils.takeScreenshot(new Object() {
        }.getClass().getEnclosingMethod().getName());
        Assert.assertTrue(idp.getPdf_file().isDisplayed());
        driver.navigate().back();
    }

    @Test(groups = {"PROD", "QAR"}, priority = 2)
    @Description
    @Severity(SeverityLevel.CRITICAL)
    public void walletFlowAndroid() throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        idp.getWallet_button().click();
        idp.getWallet_disclaimer_accept_button().click();
        new AndroidActions(driver).changeViewAndroid();
        idp.getAdd_card_toWallet().click();
        utils.waitElement(idp.getCard_added_toWallet());
        utils.takeScreenshot(new Object() {
        }.getClass().getEnclosingMethod().getName());
        Assert.assertTrue(idp.getCard_added_toWallet().isDisplayed());
        idp.getRemove_card_fromWallet().click();
    }

    @Test(groups = {"SMOKE"}, priority = 3)
    @Description("Check if find a dentist link is working")
    @Severity(SeverityLevel.MINOR)
    public void idCardFindDentistLink() {
        driver.navigate().back();
    }

    @Test(groups = {"SMOKE"}, priority = 3)
    @Description("Check if electronic claims phone number when clicked land user to dialer app")
    @Severity(SeverityLevel.MINOR)
    public void idCardElectronicClaimsPhoneNumber() {
        driver.navigate().back();
    }

    @Test(groups = {"SMOKE"}, priority = 3)
    @Description("Check if sunlife.com link is working")
    @Severity(SeverityLevel.MINOR)
    public void idCardSunlifeLink() {
        driver.navigate().back();
    }


}
