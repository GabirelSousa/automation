package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class FindDentist extends AppiumUtils {
    public FindDentist(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    // ----- 1. SELECT YOUR PLAN -----
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Select your plan type.")
    WebElement selectPlanLabel;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Most people have a PPO plan.")
    WebElement planText;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "PPO plans")
    WebElement ppo_PlansCheck;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "DHMO or Prepaid plans")
    WebElement dhmo_prepaid_PlansCheckbox;


    // ------ 2. SELECT YOUR NETWORK -----
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Select your Network.")
    WebElement selectNetworkLabel;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Not sure what to choose?")
    WebElement notSureLink;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sun Life Financial\"]/XCUIElementTypeOther[16]/XCUIElementTypeOther")
    WebElement networkDropdown;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeMenuItem[@name=\"Sun Life Dental Network®\"]")
    WebElement sunlife_dental_network_dropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Sun Life Focus Dental Network®")
    WebElement sunlife_focus_dental_network_dropdownOption;

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sun Life Financial\"]/XCUIElementTypeOther[17]/XCUIElementTypeOther")
    WebElement stateOfResidence_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sun Life Financial\"]/XCUIElementTypeOther[18]/XCUIElementTypeOther")
    WebElement network_dropdownOption;

    // ----- 3. SET YOUR CRITERIA -----
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Set Criteria.")
    WebElement setCriteriaLabel;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Search for the closest dentist")
    WebElement search_closestDentist_tab;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for the closest dentist, tab panel\"]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    WebElement zipCode;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for the closest dentist, tab panel\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    WebElement dentistType_Dropdown;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeMenuItem[@name=\"All dentists\"]")
    WebElement allDentist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "General Dentist")
    WebElement generalDentist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "All Specialists")
    WebElement allSpecialist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Endodontist")
    WebElement endodontist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Oral and Maxillofacial Surgery")
    WebElement oral_Maxilar_Surgery_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Orthodontist")
    WebElement orthodontist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Pedodontist (Pediatric Dentist)")
    WebElement pedodontist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Periodontist")
    WebElement periodontist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Prosthodontist")
    WebElement prosthodontist_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for the closest dentist, tab panel\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    WebElement distance_Dropdown;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "1 mile")
    WebElement OneMile_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "5 miles")
    WebElement fiveMiles_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "10 miles")
    WebElement Miles_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "20 miles")
    WebElement twentyMiles_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "60 miles")
    WebElement sixtyMiles_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "100 miles")
    WebElement hundredMiles_DropdownOption;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "125 miles")
    WebElement hundredTwentyFiveMiles_DropdownOption;

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Search for a specific dentist")
    WebElement search_specificDentist_tab;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Dentist's Name")
    WebElement dentistName_Checkbox;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    WebElement lastName_Field;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    WebElement firstName_Field;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[8]/XCUIElementTypeTextField")
    WebElement city_Field;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[9]/XCUIElementTypeOther")
    WebElement state_DropDown;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Facility Name")
    WebElement facilityName_Checkbox;

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    WebElement facilityName_Field;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
    WebElement facilityCity_Field;
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[8]/XCUIElementTypeOther")
    WebElement facilityState_Dropdown;

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "Search dentists")
    WebElement searchDentist_Button;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"\uF1D0, Find a Dentist\"]")
    @iOSXCUITFindBy(xpath = "")
    WebElement fadBottomMenuTab;


}
