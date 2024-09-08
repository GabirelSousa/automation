package suites.android;

import androidPages.LoginPage;
import commomUtils.AndroidActions;
import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import androidPages.FindDentistPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BottomMenu;
import utils.AndroidBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class FAD extends AndroidBase {

    @BeforeClass(alwaysRun = true)
    @Parameters({"email", "password"})
    public void envSetup(String email, String password) throws IOException {
        LoginPage lp = new LoginPage(driver);
        AppiumUtils utils = new AppiumUtils(driver);
        BottomMenu bm = new BottomMenu(driver);
        utils.waitElement(lp.getLogin_button());
        lp.inputTextAndroid(lp.getLogin_email_address_field(), email);
        lp.inputTextAndroid(lp.getLogin_password_field(), password);
        lp.getLogin_button().click();
        utils.waitElement(bm.getMenu_digital_id());
        bm.getMenu_fad().click();
    }

    @Test(dataProvider = "getData", groups = {"QAR", "PROD"})
    @Description("Validate data is pre-loaded and matching - PPO network")
    @Severity(SeverityLevel.NORMAL)
    public void checkPPONetwork(HashMap<String, String> data) throws FileNotFoundException, InterruptedException {
        FindDentistPage fdp = new FindDentistPage(driver);
        String network = data.get("fad_ppo_network");
        fdp.swipeUp();
        switch (network) {
            case "Sun Life Dental Network®":
                Assert.assertTrue(fdp.getSunlife_dental_network_dropdownOption().isDisplayed());
                break;
            case "Sun Life Focus Dental Network®":
                Assert.assertTrue(fdp.getSunlife_focus_dental_network_dropdownOption().isDisplayed());
                break;
        }

    }

    @Test(dataProvider = "getData", groups = {"SMOKE"})
    @Description("Validate data is pre-loaded and matching - Pre paid")
    @Severity(SeverityLevel.NORMAL)
    public void checkPrePaidNetwork(HashMap<String, String> data) throws InterruptedException, FileNotFoundException {
        FindDentistPage fdp = new FindDentistPage(driver);
        String prepaid_network = data.get("fad_prepaid_network");
        fdp.swipeUp();
        boolean networkAvailable = driver.findElement(By.xpath(STR."//XCUIElementTypeStaticText[@name=\{prepaid_network}]")).isDisplayed();
        Assert.assertTrue(networkAvailable);

    }

    @Test(dataProvider = "getData", groups = {"SMOKE"})
    @Description("Validate data is pre-loaded and matching - pre paid net work state")
    @Severity(SeverityLevel.NORMAL)
    public void checkPrePaidNetworkState(HashMap<String, String> data) throws FileNotFoundException, InterruptedException {
        FindDentistPage fdp = new FindDentistPage(driver);
        String state_of_residence = data.get("fad_state_of_residence");
        fdp.swipeUp();
        boolean networkState = driver.findElement(By.xpath(STR."//XCUIElementTypeStaticText[@name=\{state_of_residence}]")).isDisplayed();
        Assert.assertTrue(networkState);
    }

    @Test(groups = {"QAR", "PROD"})
    @Description("Do a simple search using closest dentist option")
    @Severity(SeverityLevel.NORMAL)
    public void simpleSearchClosestDentist() throws FileNotFoundException {
        FindDentistPage fdp = new FindDentistPage(driver);
        fdp.getSearch_closestDentist_tab().click();
        fdp.inputTextAndroid(fdp.getZipCode(), "33126");
        fdp.getSearchDentist_Button().click();
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"fad-web-view\"]")).isDisplayed());

    }

    @Test(groups = {"QAR", "PROD"})
    @Description("Do a simple search using specific dentist option - Dentist's Name")
    @Severity(SeverityLevel.NORMAL)
    public void simpleSearchDentistName() throws FileNotFoundException {
        FindDentistPage fdp = new FindDentistPage(driver);
        fdp.getSearch_specificDentist_tab().click();
        fdp.getDentistName_Checkbox().click();
        fdp.inputTextAndroid(fdp.getLastName_Field(), "a");
        fdp.getState_DropDown().click();
        driver.findElement(AppiumBy.accessibilityId("Florida")).click();
        fdp.getSearchDentist_Button().click();
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"fad-web-view\"]")).isDisplayed());
    }

    @Test(groups = {"QAR", "PROD"})
    @Description("Do a simple search using specific dentist option - Facility Name")
    @Severity(SeverityLevel.NORMAL)
    public void simpleSearchFacilityName() throws FileNotFoundException {
        FindDentistPage fdp = new FindDentistPage(driver);
        fdp.getSearch_specificDentist_tab().click();
        fdp.getFacilityName_Checkbox().click();
        fdp.inputTextAndroid(fdp.getFacilityName_Field(), "a");
        fdp.getState_DropDown().click();
        driver.findElement(AppiumBy.accessibilityId("Florida")).click();
        fdp.getSearchDentist_Button().click();
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"fad-web-view\"]")).isDisplayed());
    }
}
