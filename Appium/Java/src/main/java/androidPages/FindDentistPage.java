package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class FindDentistPage extends AndroidActions {

    AndroidDriver driver;

    public FindDentistPage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ------ 2. SELECT YOUR NETWORK -----
    @AndroidFindBy(xpath = "//*[@text='Sun Life Dental Network® down']")
    WebElement sunlife_dental_network_dropdownOption;
    @AndroidFindBy(xpath = "//*[@text='Sun Life Focus Dental Network® down']")
    WebElement sunlife_focus_dental_network_dropdownOption;
    @AndroidFindBy(xpath = "*//android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View")
    WebElement stateOfResidence_DropdownOption;
    @AndroidFindBy(xpath = "*//android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View")
    WebElement network_dropdownOption;

    // ----- 3. SET YOUR CRITERIA -----
    @AndroidFindBy(xpath = "//*[@text='Search for the closest dentist']")
    WebElement search_closestDentist_tab;
    @AndroidFindBy(xpath = "//*[@hint='ZIP code*']")
    WebElement zipCode;

    @AndroidFindBy(xpath = "//*[@text='Search for a specific dentist']")
    WebElement search_specificDentist_tab;
    @AndroidFindBy(xpath = "*//android.view.View[1]/android.widget.Image/android.view.View")
    WebElement dentistName_Checkbox;
    @AndroidFindBy(xpath = "//*[@hint='Last name*']")
    WebElement lastName_Field;
    @AndroidFindBy(xpath = "//*[@text='State* down']")
    WebElement state_DropDown;
    @AndroidFindBy(xpath = "*//android.view.View[2]/android.widget.Image/android.view.View")
    WebElement facilityName_Checkbox;
    @AndroidFindBy(xpath = "//*[@hint='Facility name*']")
    WebElement facilityName_Field;
    @AndroidFindBy(xpath = "//*[@text='State* down']")
    WebElement facilityState_Dropdown;

    @AndroidFindBy(xpath = "*//android.widget.Button[@text='Search dentists']")
    WebElement searchDentist_Button;


    public WebElement getSunlife_dental_network_dropdownOption() {
        return sunlife_dental_network_dropdownOption;
    }

    public WebElement getSunlife_focus_dental_network_dropdownOption() {
        return sunlife_focus_dental_network_dropdownOption;
    }

    public WebElement getStateOfResidence_DropdownOption() {
        return stateOfResidence_DropdownOption;
    }

    public WebElement getNetwork_dropdownOption() {
        return network_dropdownOption;
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
