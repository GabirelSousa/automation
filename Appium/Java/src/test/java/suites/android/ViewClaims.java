package suites.android;

import androidPages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import androidPages.ViewClaimsPage;
import org.testng.Assert;
import commomUtils.AndroidActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.AndroidBase;
import commomUtils.AppiumUtils;
import pages.BottomMenu;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ViewClaims extends AndroidBase {


    @BeforeClass(alwaysRun = true)
    @Parameters({"email","password"})
    public void envSetup(String email, String password) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        BottomMenu bm = new BottomMenu(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextAndroid(lp.getLogin_email_address_field(), email);
        lp.inputTextAndroid(lp.getLogin_password_field(), password);
        lp.getLogin_button().click();
        utils.waitElement(bm.getMenu_view_claims());
        bm.getMenu_view_claims().click();
    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in view claims screen - Card title")
    @Severity(SeverityLevel.NORMAL)
    public void viewClaimsCardTitle(HashMap<String, String> data) throws FileNotFoundException {
        ViewClaimsPage vcp = new ViewClaimsPage(driver);
        Assert.assertEquals(vcp.getClaims_card_title().getText(), data.get("card_title"));

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in view claims screen - Patient")
    @Severity(SeverityLevel.NORMAL)
    public void viewClaimsPatient(HashMap<String, String> data) throws FileNotFoundException {
        ViewClaimsPage vcp = new ViewClaimsPage(driver);
        Assert.assertEquals(vcp.getClaims_card_patient_name().getText(), data.get("patient"));

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in view claims screen - Relationship")
    @Severity(SeverityLevel.NORMAL)
    public void viewClaimsRelationship(HashMap<String, String> data) throws FileNotFoundException {
        ViewClaimsPage vcp = new ViewClaimsPage(driver);
        Assert.assertEquals(vcp.getClaims_card_relationship().getText(), data.get("relationship"));

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in view claims screen - Claim number")
    @Severity(SeverityLevel.NORMAL)
    public void viewClaimsNumber(HashMap<String, String> data) throws FileNotFoundException {
        ViewClaimsPage vcp = new ViewClaimsPage(driver);
        Assert.assertEquals(vcp.getClaims_card_number().getText(), data.get("claim_number"));

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in view claims screen - Responsibility")
    @Severity(SeverityLevel.NORMAL)
    public void viewClaimsResponsibility(HashMap<String, String> data) throws FileNotFoundException {
        ViewClaimsPage vcp = new ViewClaimsPage(driver);
        Assert.assertEquals(vcp.getClaims_card_responsibility().getText(), data.get("responsibility"));

    }
//View claims:
//✅ Displays no claims message if user does not have claims cyntia@appstore.com Peri123!
//✅ Claims are displayed and scroll
//✅ Share PDF file (compare data if possible)
}
