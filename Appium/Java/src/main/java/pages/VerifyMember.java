package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class VerifyMember extends AppiumUtils {
    public VerifyMember(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id = "com.sunlifeus:id/verify-member-id-toggle")
    @iOSXCUITFindBy(accessibility = "verify-member-id-toggle")
    private WebElement memberId_radio_button;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-member-member-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Member ID Enter Member ID\"])[2]")
    private WebElement memberId_text_field;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-memeber-dob-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Member's date of birth MM/DD/YYYY\"])[2]")
    private WebElement memberID_dob_text_field;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-ssn-toggle")
    @iOSXCUITFindBy(id = "verify-ssn-toggle")
    private WebElement lastSSN_ratio_button;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-memeber-first-name-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"First name Enter first name\"])[2]")
    private WebElement first_name_text_field;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-memeber-last-name-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Last name Enter last name\"])[2]")
    private WebElement last_name_text_field;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-memeber-dob-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Date of birth MM/DD/YYYY\"])[2]")
    private WebElement ssn_Dob_text_field;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-memeber-last-ssn-field")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Last 4 digits of social security number Enter last 4 digits of social security number\"])[2]")
    private WebElement ssn_text_field;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'We couldn’t verify your account.')]")
    @iOSXCUITFindBy(accessibility = "We couldn’t verify your account.")
    private WebElement error_modal_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'It looks like the information you provided does not match our records. Please try again.')]")
    @iOSXCUITFindBy(xpath = "It looks like the information you provided does not match our records. Please try again.")
    private WebElement error_modal_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Try again')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Try again\"])[3]")
    private WebElement error_modal_try_again_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Need help?')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Need help?\"])[2]")
    private WebElement error_modal_need_help_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Okay')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Okay\"])[3]")
    private WebElement error_modal_ok_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Need additional help?')]")
    @iOSXCUITFindBy(accessibility = "Need additional help?")
    private WebElement additional_help_modal_title;
    @AndroidFindBy(id = "com.sunlifeus:id/verify-title-text]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"verify-title-text\"])[2]")
    private WebElement additional_help_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Okay')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Okay\"])[3]")
    private WebElement additional_help_ok_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '800-434-2638')]")
    private WebElement additional_help_phone_number;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Verify\"]")
    @iOSXCUITFindBy(accessibility = "verify-button")
    private WebElement verify_button;

    public WebElement getMemberId_radio_button() {
        return memberId_radio_button;
    }

    public void setMemberId_radio_button(WebElement memberId_radio_button) {
        this.memberId_radio_button = memberId_radio_button;
    }

    public WebElement getMemberId_text_field() {
        return memberId_text_field;
    }

    public void setMemberId_text_field(WebElement memberId_text_field) {
        this.memberId_text_field = memberId_text_field;
    }

    public WebElement getMemberID_dob_text_field() {
        return memberID_dob_text_field;
    }

    public void setMemberID_dob_text_field(WebElement memberID_dob_text_field) {
        this.memberID_dob_text_field = memberID_dob_text_field;
    }

    public WebElement getLastSSN_ratio_button() {
        return lastSSN_ratio_button;
    }

    public void setLastSSN_ratio_button(WebElement lastSSN_ratio_button) {
        this.lastSSN_ratio_button = lastSSN_ratio_button;
    }

    public WebElement getFirst_name_text_field() {
        return first_name_text_field;
    }

    public void setFirst_name_text_field(WebElement first_name_text_field) {
        this.first_name_text_field = first_name_text_field;
    }

    public WebElement getLast_name_text_field() {
        return last_name_text_field;
    }

    public void setLast_name_text_field(WebElement last_name_text_field) {
        this.last_name_text_field = last_name_text_field;
    }

    public WebElement getSsn_Dob_text_field() {
        return ssn_Dob_text_field;
    }

    public void setSsn_Dob_text_field(WebElement ssn_Dob_text_field) {
        this.ssn_Dob_text_field = ssn_Dob_text_field;
    }

    public WebElement getSsn_text_field() {
        return ssn_text_field;
    }

    public void setSsn_text_field(WebElement ssn_text_field) {
        this.ssn_text_field = ssn_text_field;
    }

    public WebElement getError_modal_title() {
        return error_modal_title;
    }

    public void setError_modal_title(WebElement error_modal_title) {
        this.error_modal_title = error_modal_title;
    }

    public WebElement getError_modal_text() {
        return error_modal_text;
    }

    public void setError_modal_text(WebElement error_modal_text) {
        this.error_modal_text = error_modal_text;
    }

    public WebElement getError_modal_try_again_button() {
        return error_modal_try_again_button;
    }

    public void setError_modal_try_again_button(WebElement error_modal_try_again_button) {
        this.error_modal_try_again_button = error_modal_try_again_button;
    }

    public WebElement getError_modal_need_help_button() {
        return error_modal_need_help_button;
    }

    public void setError_modal_need_help_button(WebElement error_modal_need_help_button) {
        this.error_modal_need_help_button = error_modal_need_help_button;
    }

    public WebElement getError_modal_ok_button() {
        return error_modal_ok_button;
    }

    public void setError_modal_ok_button(WebElement error_modal_ok_button) {
        this.error_modal_ok_button = error_modal_ok_button;
    }

    public WebElement getAdditional_help_modal_title() {
        return additional_help_modal_title;
    }

    public void setAdditional_help_modal_title(WebElement additional_help_modal_title) {
        this.additional_help_modal_title = additional_help_modal_title;
    }

    public WebElement getAdditional_help_text() {
        return additional_help_text;
    }

    public void setAdditional_help_text(WebElement additional_help_text) {
        this.additional_help_text = additional_help_text;
    }

    public WebElement getAdditional_help_ok_button() {
        return additional_help_ok_button;
    }

    public void setAdditional_help_ok_button(WebElement additional_help_ok_button) {
        this.additional_help_ok_button = additional_help_ok_button;
    }

    public WebElement getAdditional_help_phone_number() {
        return additional_help_phone_number;
    }

    public void setAdditional_help_phone_number(WebElement additional_help_phone_number) {
        this.additional_help_phone_number = additional_help_phone_number;
    }

    public WebElement getVerify_button() {
        return verify_button;
    }

    public void setVerify_button(WebElement verify_button) {
        this.verify_button = verify_button;
    }
}
