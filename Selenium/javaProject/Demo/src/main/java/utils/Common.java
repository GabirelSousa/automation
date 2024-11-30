package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Common {

    public WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }

    public void useFirefox(WebDriver driver, String BaseUrl) {


    }

    public void useChrome() {

    }


}
