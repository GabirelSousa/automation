package suites.ios;

import io.appium.java_client.AppiumBy;
import iosPages.CardIDPage;
import iosPages.LoginPage;
import commomUtils.IOSActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.IDCard;
import utils.IOSBase;
import commomUtils.AppiumUtils;
import pages.BottomMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardID extends IOSBase {


    @BeforeClass(alwaysRun = true)
    @Parameters({"email", "password"})
    public void envSetup(String email, String password) throws IOException {
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        BottomMenu bm = new BottomMenu(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), email);
        lp.inputTextReturn(lp.getLogin_password_text_box(), password);
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
    public void shareFlowIOS() throws FileNotFoundException, InterruptedException {
        CardIDPage idp = new CardIDPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        idp.getShare_button().click();
        new IOSActions(driver).changeViewIos();
        idp.getShare_print_option().click();
        Thread.sleep(1000);
        utils.takeScreenshot(new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancel']")).click();
        Assert.assertTrue(idp.getShare_button().isDisplayed());
    }

    @Test(groups = {"PROD", "QAR"}, priority = 2)
    @Description
    @Severity(SeverityLevel.CRITICAL)
    public void walletFlowIOS() throws FileNotFoundException {
        CardIDPage idp = new CardIDPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        idp.getWallet_button().click();
        idp.getWallet_disclaimer_accept_button().click();
        new IOSActions(driver).changeViewIos();
        utils.waitElement(idp.getApple_wallet_add_button());
        idp.getApple_wallet_add_button().click();
        driver.executeScript("mobile: activateApp", Map.ofEntries(Map.entry("bundleId", "com.apple.Passbook")));
        utils.waitElement(driver.findElement(AppiumBy.accessibilityId("SunLife")));
        utils.takeScreenshot(new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.executeScript("mobile: clearApp", Map.ofEntries(Map.entry("bundleId", "com.apple.Passbook")));
        driver.executeScript("mobile: activateApp", Map.ofEntries(Map.entry("bundleId", "com.sunlifeus")));
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

    }

    @Test(groups = {"SMOKE"}, priority = 3)
    @Description("Check if sunlife.com link is working")
    @Severity(SeverityLevel.MINOR)
    public void idCardSunlifeLink() {
        driver.navigate().back();
    }
}
