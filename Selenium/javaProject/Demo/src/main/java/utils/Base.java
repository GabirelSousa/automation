package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home_Page;

import java.time.Duration;

public class Base {
    public static void main(String[] args){
        String baseUrl = "https://parabank.parasoft.com/";
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/gasou/Documents/automation/Selenium/javaProject/Demo/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);


        
    }
}
