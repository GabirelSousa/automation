package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword_Page {

    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "address.street")
    private WebElement address;
    @FindBy(id = "address.city")
    private WebElement city;
    @FindBy(id = "address.state")
    private WebElement state;
    @FindBy(id = "address.zipCode")
    private WebElement zipCode;
    @FindBy(id = "ssn")
    private WebElement ssn;
    @FindBy(xpath = "//input[@value='Find My Login Info']")
    private WebElement find_my_login_button;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getSsn() {
        return ssn;
    }

    public WebElement getFind_my_login_button() {
        return find_my_login_button;
    }
}
