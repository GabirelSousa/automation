package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

    WebDriver driver;

    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement login_field;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password_field;
    @FindBy(xpath = "//input[@value='Log In']")
    WebElement log_in_button;
    @FindBy(linkText = "Forgot login info?")
    WebElement forgot_login_info_link;
    @FindBy(linkText = "Register")
    WebElement register_link;

    public void inputField(WebElement webelement, String input){
        webelement.sendKeys(input);
    }

    public WebElement getLogin_field() {
        return login_field;
    }

    public WebElement getPassword_field() {
        return password_field;
    }

    public WebElement getLog_in_button() {
        return log_in_button;
    }

    public WebElement getForgot_login_info_link() {
        return forgot_login_info_link;
    }

    public WebElement getRegister_link() {
        return register_link;
    }


}
