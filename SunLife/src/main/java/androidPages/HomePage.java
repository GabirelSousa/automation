package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class HomePage extends AndroidActions {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.sunlifeus:id/home-welcome")
    private WebElement welcomeMsg;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Active')]")
    private WebElement accountStatusActive;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Terminated')]")
    private WebElement accountStatusTerminate;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-name-text")
    private WebElement policyName;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-number-text")
    private WebElement policyNumber;
    @AndroidFindBy(id = "com.sunlifeus:id/home-policy-member-id-text")
    private WebElement memberID;
    @AndroidFindBy(id = "com.sunlifeus:id/home-coverage-text")
    private WebElement coverageType;
    @AndroidFindBy(id = "com.sunlifeus:id/home-plan-year-text")
    private WebElement planYear;
    @AndroidFindBy(id = "com.sunlifeus:id/home-network-text")
    private WebElement network;
    @AndroidFindBy(id = "com.sunlifeus:id/home-missing-tooth-yes-no-text")
    private WebElement missingToothCoverage;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'The information provided is not a guarantee of coverage or plan benefits. Issued dental insurance policies or dental plans control all benefit determinations, including all limitations, exclusions, and restrictions. The information provided does not reflect dental services which may have been performed but for which a claim has not yet been processed. Additionally, some dental services and procedures are subject to review. For evaluation or determination of benefit amounts, we recommend that a dental treatment plan be submitted to us for review before treatment begins.')]")
    private WebElement home_disclaimer_text_1;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'In all states except New York, insurance products and prepaid dental products are underwritten or provided by Sun Life Assurance Company of Canada (Wellesley Hills, MA) (\"SLOC\") and by Union Security Insurance Company (Kansas City, MO), administered by SLOC. In certain states prepaid dental products are provided by 0 affiliated with SLOC. In New York, insurance products and prepaid dental products are underwritten or provided by Sun Life and Health Insurance Company (U.S.) (Lansing, MI) (\"SLHICUS\") or by Union Security Life Insurance Company of New York (Fayetteville, NY), administered by SLHICUS')]")
    private WebElement home_disclaimer_text_2;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'©2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at 0')]")
    private WebElement home_disclaimer_text_3;
    @AndroidFindBy(id = "com.sunlifeus:id/home-quick-link-text")
    private WebElement deductibles_maximumsButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"In-network\"]")
    private WebElement inNetworkTab_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Out-of-network\"]")
    private WebElement outOfNetworkTab_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Deductibles & maximums\"]")
    private WebElement dropList_DeductiblesMaximums;
    @AndroidFindBy(xpath = "//android/widget.TextView[contains(@text,'• If this is a Prepaid/DHMO member, there are no deductibles & maximums. \n" +
            "\n" +
            "• If this is a PPO member, they will be available when the plan is Active.')]")
    private WebElement deductible_maximus_unavailable_bullet;
    @AndroidFindBy(id = "com.sunlifeus:id/retry-button")
    private WebElement deductible_maximus_unavailable_retry_button;


    public WebElement getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(WebElement welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public WebElement getAccountStatusActive() {
        return accountStatusActive;
    }

    public void setAccountStatusActive(WebElement accountStatusActive) {
        this.accountStatusActive = accountStatusActive;
    }

    public WebElement getAccountStatusTerminate() {
        return accountStatusTerminate;
    }

    public void setAccountStatusTerminate(WebElement accountStatusTerminate) {
        this.accountStatusTerminate = accountStatusTerminate;
    }

    public WebElement getPolicyName() {
        return policyName;
    }

    public void setPolicyName(WebElement policyName) {
        this.policyName = policyName;
    }

    public WebElement getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(WebElement policyNumber) {
        this.policyNumber = policyNumber;
    }

    public WebElement getMemberID() {
        return memberID;
    }

    public void setMemberID(WebElement memberID) {
        this.memberID = memberID;
    }

    public WebElement getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(WebElement coverageType) {
        this.coverageType = coverageType;
    }

    public WebElement getPlanYear() {
        return planYear;
    }

    public void setPlanYear(WebElement planYear) {
        this.planYear = planYear;
    }

    public WebElement getNetwork() {
        return network;
    }

    public void setNetwork(WebElement network) {
        this.network = network;
    }

    public WebElement getMissingToothCoverage() {
        return missingToothCoverage;
    }

    public void setMissingToothCoverage(WebElement missingToothCoverage) {
        this.missingToothCoverage = missingToothCoverage;
    }

    public WebElement getHome_disclaimer_text_1() {
        return home_disclaimer_text_1;
    }

    public void setHome_disclaimer_text_1(WebElement home_disclaimer_text_1) {
        this.home_disclaimer_text_1 = home_disclaimer_text_1;
    }

    public WebElement getHome_disclaimer_text_2() {
        return home_disclaimer_text_2;
    }

    public void setHome_disclaimer_text_2(WebElement home_disclaimer_text_2) {
        this.home_disclaimer_text_2 = home_disclaimer_text_2;
    }

    public WebElement getHome_disclaimer_text_3() {
        return home_disclaimer_text_3;
    }

    public void setHome_disclaimer_text_3(WebElement home_disclaimer_text_3) {
        this.home_disclaimer_text_3 = home_disclaimer_text_3;
    }

    public WebElement getDeductibles_maximumsButton() {
        return deductibles_maximumsButton;
    }

    public void setDeductibles_maximumsButton(WebElement deductibles_maximumsButton) {
        this.deductibles_maximumsButton = deductibles_maximumsButton;
    }

    public WebElement getInNetworkTab_DeductiblesMaximums() {
        return inNetworkTab_DeductiblesMaximums;
    }

    public void setInNetworkTab_DeductiblesMaximums(WebElement inNetworkTab_DeductiblesMaximums) {
        this.inNetworkTab_DeductiblesMaximums = inNetworkTab_DeductiblesMaximums;
    }

    public WebElement getOutOfNetworkTab_DeductiblesMaximums() {
        return outOfNetworkTab_DeductiblesMaximums;
    }

    public void setOutOfNetworkTab_DeductiblesMaximums(WebElement outOfNetworkTab_DeductiblesMaximums) {
        this.outOfNetworkTab_DeductiblesMaximums = outOfNetworkTab_DeductiblesMaximums;
    }

    public WebElement getDropList_DeductiblesMaximums() {
        return dropList_DeductiblesMaximums;
    }

    public void setDropList_DeductiblesMaximums(WebElement dropList_DeductiblesMaximums) {
        this.dropList_DeductiblesMaximums = dropList_DeductiblesMaximums;
    }

    public WebElement getDeductible_maximus_unavailable_bullet() {
        return deductible_maximus_unavailable_bullet;
    }

    public void setDeductible_maximus_unavailable_bullet(WebElement deductible_maximus_unavailable_bullet) {
        this.deductible_maximus_unavailable_bullet = deductible_maximus_unavailable_bullet;
    }

    public WebElement getDeductible_maximus_unavailable_retry_button() {
        return deductible_maximus_unavailable_retry_button;
    }

    public void setDeductible_maximus_unavailable_retry_button(WebElement deductible_maximus_unavailable_retry_button) {
        this.deductible_maximus_unavailable_retry_button = deductible_maximus_unavailable_retry_button;
    }
}
