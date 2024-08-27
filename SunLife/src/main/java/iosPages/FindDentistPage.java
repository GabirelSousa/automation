package iosPages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class FindDentistPage extends IOSActions {

    IOSDriver driver;

    public FindDentistPage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ------ 2. SELECT YOUR NETWORK -----
    @iOSXCUITFindBy(accessibility = "Sun Life Dental Network®")
    WebElement sunlife_dental_network_dropdownOption;
    @iOSXCUITFindBy(accessibility = "Sun Life Focus Dental Network®")
    WebElement sunlife_focus_dental_network_dropdownOption;


    // ----- 3. SET YOUR CRITERIA -----
    @iOSXCUITFindBy(accessibility = "Search for the closest dentist")
    WebElement search_closestDentist_tab;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for the closest dentist, tab panel\"]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    WebElement zipCode;

    @iOSXCUITFindBy(accessibility = "Search for a specific dentist")
    WebElement search_specificDentist_tab;
    @iOSXCUITFindBy(accessibility = "Dentist's Name")
    WebElement dentistName_Checkbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    WebElement lastName_Field;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[9]/XCUIElementTypeOther")
    WebElement state_DropDown;
    @iOSXCUITFindBy(accessibility = "Facility Name")
    WebElement facilityName_Checkbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    WebElement facilityName_Field;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Search for a specific dentist, tab panel\"]/XCUIElementTypeOther[8]/XCUIElementTypeOther")
    WebElement facilityState_Dropdown;

    @iOSXCUITFindBy(accessibility = "Search dentists")
    WebElement searchDentist_Button;


    public WebElement getSunlife_dental_network_dropdownOption() {
        return sunlife_dental_network_dropdownOption;
    }

    public WebElement getSunlife_focus_dental_network_dropdownOption() {
        return sunlife_focus_dental_network_dropdownOption;
    }

    public WebElement getSearch_closestDentist_tab() {
        return search_closestDentist_tab;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getSearch_specificDentist_tab() {
        return search_specificDentist_tab;
    }

    public WebElement getDentistName_Checkbox() {
        return dentistName_Checkbox;
    }

    public WebElement getLastName_Field() {
        return lastName_Field;
    }

    public WebElement getState_DropDown() {
        return state_DropDown;
    }

    public WebElement getFacilityName_Checkbox() {
        return facilityName_Checkbox;
    }

    public WebElement getFacilityName_Field() {
        return facilityName_Field;
    }

    public WebElement getFacilityState_Dropdown() {
        return facilityState_Dropdown;
    }

    public WebElement getSearchDentist_Button() {
        return searchDentist_Button;
    }
}
