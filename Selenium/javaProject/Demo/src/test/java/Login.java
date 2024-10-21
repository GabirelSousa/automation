import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page;
import utils.Common;

import java.time.Duration;

public class Login {
    private WebDriver driver;


    @BeforeClass
    public void openBrowser() {
        String baseUrl = "https://parabank.parasoft.com/";
        System.setProperty("webdriver.chrome.driver","/Users/gasou/Documents/automation/Selenium/javaProject/Demo/src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

    }

    @Test
    public void login() {
        Home_Page hp = new Home_Page(driver);
        hp.inputField(hp.getLogin_field(), "gasous4@gmail.com");
        hp.inputField(hp.getPassword_field(),"Gabe@1234");
    }
}
