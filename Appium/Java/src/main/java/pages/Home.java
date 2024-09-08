package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class Home extends AppiumUtils {
    public Home(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id = "com.sunlifeus:id/home-welcome")
    @iOSXCUITFindBy(accessibility = "home-welcome")
    private WebElement welcomeMsg;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Active')]")
    @iOSXCUITFindBy(accessibility = "Active")
    private WebElement accountStatusActive;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Terminated')]")
    @iOSXCUITFindBy(accessibility = "Terminate")
    private WebElement accountStatusTerminate;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-name-text")
    @iOSXCUITFindBy(accessibility = "home-policy-name-text")
    private WebElement policyName;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-number-text")
    @iOSXCUITFindBy(accessibility = "home-policy-number-text")
    private WebElement policyNumber;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-member-id-text")
    @iOSXCUITFindBy(accessibility = "home-policy-member-id-text")
    private WebElement memberID;
    @AndroidFindBy(id = "com.sunlifeus:id/home-coverage-text")
    @iOSXCUITFindBy(accessibility = "home-coverage-text")
    private WebElement coverageType;
    @AndroidFindBy(id = "com.sunlifeus:id/home-plan-year-text")
    @iOSXCUITFindBy(accessibility = "home-plan-year-text")
    private WebElement planYear;
    @AndroidFindBy(id = "com.sunlifeus:id/home-network-text")
    @iOSXCUITFindBy(accessibility = "home-network-text")
    private WebElement network;
    @AndroidFindBy(id = "com.sunlifeus:id/home-missing-tooth-yes-no-text")
    @iOSXCUITFindBy(accessibility = "home-missing-tooth-yes-no-text")
    private WebElement missingToothCoverage;
    @iOSXCUITFindBy(accessibility = "The information provided is not a guarantee of coverage or plan benefits. Issued dental insurance policies or dental plans control all benefit determinations, including all limitations, exclusions, and restrictions. The information provided does not reflect dental services which may have been performed but for which a claim has not yet been processed. Additionally, some dental services and procedures are subject to review. For evaluation or determination of benefit amounts, we recommend that a dental treatment plan be submitted to us for review before treatment begins. In all states except New York, insurance products and prepaid dental products are underwritten or provided by Sun Life Assurance Company of Canada (Wellesley Hills, MA) (\"SLOC\") and by Union Security Insurance Company (Kansas City, MO), administered by SLOC. In certain states prepaid dental products are provided by  affiliated with SLOC. In New York, insurance products and prepaid dental products are underwritten or provided by Sun Life and Health Insurance Company (U.S.) (Lansing, MI) (\"SLHICUS\") or by Union Security Life Insurance Company of New York (Fayetteville, NY), administered by SLHICUS ©2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at ")
    private WebElement home_disclaimer_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'The information provided is not a guarantee of coverage or plan benefits. Issued dental insurance policies or dental plans control all benefit determinations, including all limitations, exclusions, and restrictions. The information provided does not reflect dental services which may have been performed but for which a claim has not yet been processed. Additionally, some dental services and procedures are subject to review. For evaluation or determination of benefit amounts, we recommend that a dental treatment plan be submitted to us for review before treatment begins.')]")
    private WebElement home_disclaimer_text_1;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'In all states except New York, insurance products and prepaid dental products are underwritten or provided by Sun Life Assurance Company of Canada (Wellesley Hills, MA) (\"SLOC\") and by Union Security Insurance Company (Kansas City, MO), administered by SLOC. In certain states prepaid dental products are provided by 0 affiliated with SLOC. In New York, insurance products and prepaid dental products are underwritten or provided by Sun Life and Health Insurance Company (U.S.) (Lansing, MI) (\"SLHICUS\") or by Union Security Life Insurance Company of New York (Fayetteville, NY), administered by SLHICUS')]")
    private WebElement home_disclaimer_text_2;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'©2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at 0')]")
    private WebElement home_disclaimer_text_3;
    @AndroidFindBy(id = "com.sunlifeus:id/home-quick-link-text")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Deductibles & maximums \uE5E1\"])[2]")
    private WebElement deductibles_maximumsButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"In-network\"]")
    @iOSXCUITFindBy(accessibility = "In-network")
    private WebElement inNetworkTab_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Out-of-network\"]")
    @iOSXCUITFindBy(accessibility = "Out-of-network")
    private WebElement outOfNetworkTab_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Deductibles & maximums\"]")
    @iOSXCUITFindBy(accessibility = "Members  ")
    private WebElement dropList_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//android/widget.TextView[contains(@text,'• If this is a Prepaid/DHMO member, there are no deductibles & maximums. \n" +
            "\n" +
            "• If this is a PPO member, they will be available when the plan is Active.')]")
    @iOSXCUITFindBy(accessibility = "Deductibles & maximums unavailable")
    private WebElement deductible_maximus_unavailable_bullet;
    @AndroidFindBy(id = "com.sunlifeus:id/retry-button")
    @iOSXCUITFindBy(accessibility = "retry-button")
    private WebElement deductible_maximus_unavailable_retry_button;
}
