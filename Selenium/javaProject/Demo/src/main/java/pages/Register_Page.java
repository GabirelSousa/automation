package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page {

    @FindBy(xpath = "//input[@name='customer.firstName']")
    private WebElement firstName;
    @FindBy(name = "customer.lastName")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='customer.address.street']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='customer.address.city']")
    private WebElement city;
    @FindBy(xpath = "//input[@name='customer.address.state']")
    private WebElement state;
    @FindBy(xpath = "//input[@name='customer.address.zipCode']")
    private WebElement zipCode;
    @FindBy(xpath = "//input[@name='customer.phoneNumber']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='customer.ssn']")
    private WebElement ssn;
    @FindBy(xpath = "//input[@name='customer.username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='customer.password']")
    private WebElement password;
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

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

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getSsn() {
        return ssn;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }
}
