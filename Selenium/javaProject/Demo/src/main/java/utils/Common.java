package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Common {


    public void useFirefox(){
        String baseUrl = "https://parabank.parasoft.com/";
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/gasou/Documents/automation/Selenium/javaProject/Demo/src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

    }

    public void useChrome(){
        String baseUrl = "https://parabank.parasoft.com/";
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/gasou/Documents/automation/Selenium/javaProject/Demo/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }
}
