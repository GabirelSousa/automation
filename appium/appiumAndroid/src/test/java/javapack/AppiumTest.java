package javapack;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import javapack.pages.base;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumTest extends base {

@BeforeClass
    public void openApp() throws MalformedURLException, InterruptedException {
    AndroidDriver<AndroidElement> driver= capabilities();
    System.out.println("finalmente");
}

@Test
    public void test1(){
    System.out.println("Meu primeiro teste");
}

}



