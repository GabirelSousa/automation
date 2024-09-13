package suites.ios;

import iosPages.LoginPage;
import iosPages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BottomMenu;
import utils.IOSBase;
import commomUtils.AppiumUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Home extends IOSBase {


    @BeforeClass(alwaysRun = true)
    @Parameters({"email","password"})
    public void envSetup(String email, String password)throws FileNotFoundException{
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        HomePage hp = new HomePage(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextReturn(lp.getLogin_email_address_text_box(), email);
        lp.inputTextReturn(lp.getLogin_password_text_box(), password);
        utils.waitElement(hp.getWelcomeMsg());
    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Name")
    @Severity(SeverityLevel.NORMAL)
    public void homeName(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getWelcomeMsg().getText(),"Welcome,\n"+data.get("mem_first_name")+data.get("mem_last_name"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Status")
    @Severity(SeverityLevel.NORMAL)
    public void homeStatus(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getAccountStatusActive().getText(), data.get("status"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Policy Name")
    @Severity(SeverityLevel.NORMAL)
    public void homePolicyName(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getPolicyName().getText(), data.get("home_policy_name_text"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Policy number")
    @Severity(SeverityLevel.NORMAL)
    public void homePolicyNumber(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getPolicyNumber().getText(), data.get("policy_number"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Member ID")
    @Severity(SeverityLevel.NORMAL)
    public void homeMemberID(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(StringUtils.right(hp.getMemberID().getText(), 4), StringUtils.right(data.get("memberID"),4), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Coverage type")
    @Severity(SeverityLevel.NORMAL)
    public void homeCoverageType(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getCoverageType().getText(), data.get("coverage_type"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Plan year")
    @Severity(SeverityLevel.NORMAL)
    public void homePlanYear(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getPlanYear().getText(), data.get("plan_year"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Network")
    @Severity(SeverityLevel.NORMAL)
    public void homeNetwork(HashMap<String, String> data) throws FileNotFoundException {
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getNetwork().getText(), data.get("network"), "Data not matching");

    }

    @Test(dataProvider = "getData")
    @Description("Validate data is matching in home screen - Missing tooth coverage")
    @Severity(SeverityLevel.NORMAL)
    public void homeMissingToothCoverage(HashMap<String, String> data) throws FileNotFoundException {
        iosPages.HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getMissingToothCoverage().getText(), data.get("missing_tooth_coverage"), "Data not matching");

    }

}//
