package iosPages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class HomePage extends IOSActions {
    IOSDriver driver;

    public HomePage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "home-welcome")
    private WebElement welcomeMsg;
    @iOSXCUITFindBy(accessibility = "Active")
    private WebElement accountStatusActive;
    @iOSXCUITFindBy(accessibility = "Terminate")
    private WebElement accountStatusTerminate;
    @iOSXCUITFindBy(accessibility = "home-policy-name-text")
    private WebElement policyName;
    @iOSXCUITFindBy(accessibility = "home-policy-number-text")
    private WebElement policyNumber;
    @iOSXCUITFindBy(accessibility = "home-policy-member-id-text")
    private WebElement memberID;
    @iOSXCUITFindBy(accessibility = "home-coverage-text")
    private WebElement coverageType;
    @iOSXCUITFindBy(accessibility = "home-plan-year-text")
    private WebElement planYear;
    @iOSXCUITFindBy(accessibility = "home-network-text")
    private WebElement network;
    @iOSXCUITFindBy(accessibility = "home-missing-tooth-yes-no-text")
    private WebElement missingToothCoverage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Deductibles & maximums \uE5E1\"])[2]")
    private WebElement deductibles_maximumsButton;
    @iOSXCUITFindBy(accessibility = "The information provided is not a guarantee of coverage or plan benefits. Issued dental insurance policies or dental plans control all benefit determinations, including all limitations, exclusions, and restrictions. The information provided does not reflect dental services which may have been performed but for which a claim has not yet been processed. Additionally, some dental services and procedures are subject to review. For evaluation or determination of benefit amounts, we recommend that a dental treatment plan be submitted to us for review before treatment begins. In all states except New York, insurance products and prepaid dental products are underwritten or provided by Sun Life Assurance Company of Canada (Wellesley Hills, MA) (\"SLOC\") and by Union Security Insurance Company (Kansas City, MO), administered by SLOC. In certain states prepaid dental products are provided by  affiliated with SLOC. In New York, insurance products and prepaid dental products are underwritten or provided by Sun Life and Health Insurance Company (U.S.) (Lansing, MI) (\"SLHICUS\") or by Union Security Life Insurance Company of New York (Fayetteville, NY), administered by SLHICUS ©2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at ")
    private WebElement home_disclaimer_text;
    @iOSXCUITFindBy(accessibility = "Members  ")
    private WebElement dropdown;
    @iOSXCUITFindBy(accessibility = "In-network")
    private WebElement in_network_tab;
    @iOSXCUITFindBy(accessibility = "Out-of-network")
    private WebElement out_of_network_tab;
    @iOSXCUITFindBy(accessibility = "Deductibles & maximums unavailable")
    private WebElement deductible_maximus_unavailable;
    @iOSXCUITFindBy(accessibility = "retry-button")
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

    public WebElement getDeductibles_maximumsButton() {
        return deductibles_maximumsButton;
    }

    public void setDeductibles_maximumsButton(WebElement deductibles_maximumsButton) {
        this.deductibles_maximumsButton = deductibles_maximumsButton;
    }

    public WebElement getHome_disclaimer_text() {
        return home_disclaimer_text;
    }

    public void setHome_disclaimer_text(WebElement home_disclaimer_text) {
        this.home_disclaimer_text = home_disclaimer_text;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public void setDropdown(WebElement dropdown) {
        this.dropdown = dropdown;
    }

    public WebElement getIn_network_tab() {
        return in_network_tab;
    }

    public void setIn_network_tab(WebElement in_network_tab) {
        this.in_network_tab = in_network_tab;
    }

    public WebElement getOut_of_network_tab() {
        return out_of_network_tab;
    }

    public void setOut_of_network_tab(WebElement out_of_network_tab) {
        this.out_of_network_tab = out_of_network_tab;
    }

    public WebElement getDeductible_maximus_unavailable() {
        return deductible_maximus_unavailable;
    }

    public void setDeductible_maximus_unavailable(WebElement deductible_maximus_unavailable) {
        this.deductible_maximus_unavailable = deductible_maximus_unavailable;
    }

    public WebElement getDeductible_maximus_unavailable_retry_button() {
        return deductible_maximus_unavailable_retry_button;
    }

    public void setDeductible_maximus_unavailable_retry_button(WebElement deductible_maximus_unavailable_retry_button) {
        this.deductible_maximus_unavailable_retry_button = deductible_maximus_unavailable_retry_button;
    }
}
