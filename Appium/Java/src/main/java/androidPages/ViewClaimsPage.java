package androidPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class ViewClaimsPage extends AndroidActions {

    AndroidDriver driver;

    public ViewClaimsPage(AndroidDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.sunlifeus:id/claim-card-header-text0")
    private WebElement claims_card_title;
    @AndroidFindBy(id = "com.sunlifeus:id/claims-state-text0")
    private WebElement claims_card_status;
    @AndroidFindBy(id = "com.sunlifeus:id/claim-card-value-textdentalClaimsScreen.claims_patient_title_text0")
    private WebElement claims_card_patient_name;
    @AndroidFindBy(id = "com.sunlifeus:id/claim-card-value-textdentalClaimsScreen.claims_relationship_title_text0")
    private WebElement claims_card_relationship;
    @AndroidFindBy(id = "com.sunlifeus:id/claim-card-value-textdentalClaimsScreen.claims_claimnumber_title_text0")
    private WebElement claims_card_number;
    @AndroidFindBy(id = "com.sunlifeus:id/claim-card-value-textdentalClaimsScreen.claims_yourresponsibility_title_text0")
    private WebElement claims_card_responsibility;
    @AndroidFindBy(id = "com.sunlifeus:id/claim-eob-button")
    private WebElement eob_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"\uF518\")]")
    private WebElement share_button;
    @AndroidFindBy(id = "android:id/content_preview_filename")
    private WebElement file_share_options_view;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'You do not have any dental claims yet. Remember to schedule a dental checkup soon.')]")
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


