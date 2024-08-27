package iosPages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class ViewClaimsPage extends IOSActions {

    IOSDriver driver;

    public ViewClaimsPage(IOSDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility = "claim-card-header-text0")
    private WebElement claims_card_title;
    @iOSXCUITFindBy(accessibility = "claims-state-text0")
    private WebElement claims_card_status;
    @iOSXCUITFindBy(accessibility = "claim-card-value-textdentalClaimsScreen.claims_patient_title_text0")
    private WebElement claims_card_patient_name;
    @iOSXCUITFindBy(accessibility = "claim-card-value-textdentalClaimsScreen.claims_relationship_title_text0")
    private WebElement claims_card_relationship;
    @iOSXCUITFindBy(accessibility = "claim-card-value-textdentalClaimsScreen.claims_claimnumber_title_text0")
    private WebElement claims_card_number;
    @iOSXCUITFindBy(accessibility = "claim-card-value-textdentalClaimsScreen.claims_yourresponsibility_title_text0")
    private WebElement claims_card_responsibility;
    @iOSXCUITFindBy(accessibility = "claim-eob-button")
    private WebElement eob_button;
    @iOSXCUITFindBy(accessibility = "\uF518")
    private WebElement share_button;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"UIActivityContentView\"]/XCUIElementTypeOther")
    private WebElement file_share_options_view;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"You do not have any dental claims yet. Remember to schedule a dental checkup soon.\"]")
    private WebElement claims_not_available;

    public WebElement getClaims_card_title() {
        return claims_card_title;
    }

    public void setClaims_card_title(WebElement claims_card_title) {
        this.claims_card_title = claims_card_title;
    }

    public WebElement getClaims_card_status() {
        return claims_card_status;
    }

    public void setClaims_card_status(WebElement claims_card_status) {
        this.claims_card_status = claims_card_status;
    }

    public WebElement getClaims_card_patient_name() {
        return claims_card_patient_name;
    }

    public void setClaims_card_patient_name(WebElement claims_card_patient_name) {
        this.claims_card_patient_name = claims_card_patient_name;
    }

    public WebElement getClaims_card_relationship() {
        return claims_card_relationship;
    }

    public void setClaims_card_relationship(WebElement claims_card_relationship) {
        this.claims_card_relationship = claims_card_relationship;
    }

    public WebElement getClaims_card_number() {
        return claims_card_number;
    }

    public void setClaims_card_number(WebElement claims_card_number) {
        this.claims_card_number = claims_card_number;
    }

    public WebElement getClaims_card_responsibility() {
        return claims_card_responsibility;
    }

    public void setClaims_card_responsibility(WebElement claims_card_responsibility) {
        this.claims_card_responsibility = claims_card_responsibility;
    }

    public WebElement getEob_button() {
        return eob_button;
    }

    public void setEob_button(WebElement eob_button) {
        this.eob_button = eob_button;
    }

    public WebElement getShare_button() {
        return share_button;
    }

    public void setShare_button(WebElement share_button) {
        this.share_button = share_button;
    }

    public WebElement getFile_share_options_view() {
        return file_share_options_view;
    }

    public void setFile_share_options_view(WebElement file_share_options_view) {
        this.file_share_options_view = file_share_options_view;
    }

    public WebElement getClaims_not_available() {
        return claims_not_available;
    }

    public void setClaims_not_available(WebElement claims_not_available) {
        this.claims_not_available = claims_not_available;
    }
}


