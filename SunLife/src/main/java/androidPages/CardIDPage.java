package androidPages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.AndroidActions;

import java.io.FileNotFoundException;

public class CardIDPage extends AppiumUtils {

    //AndroidDriver driver;

    public CardIDPage(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ----- FRONT ----- //
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-insured-member-name")
    private WebElement member_name;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-insured-member-id")
    private WebElement member_id;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-group-name")
    private WebElement group_name;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-group-id")
    private WebElement group_id;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-legal-disclosure")
    private WebElement legal_disclosure;

    // ----- BACK ----- //
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-network-name-footer-text")
    private WebElement network_name_footer_text;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-dental-paragraph-text")
    private WebElement dental_coverage_text;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-claims-text")
    private WebElement claim_text_title;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-claims-pobox")
    private WebElement claim_text_pobox;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-electronic-claims")
    private WebElement electronic_claims_payor;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-electronic-claims-phone")
    private WebElement electronic_claim_phone;
    @AndroidFindBy(xpath = "*/android.view.ViewGroup[4]/android.widget.TextView")
    private WebElement bottom_disclaimer_1;
    @AndroidFindBy(xpath = "*/android.view.ViewGroup[5]/android.widget.TextView")
    private WebElement getBottom_disclaimer_2;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"\uDB82\uDF93, SHARE/SAVE\"]")
    private WebElement share_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add to Google Wallet Button\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    private WebElement wallet_button;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"Wallet Disclaimer\")]")
    private WebElement wallet_disclaimer_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"Sun Life provides the wallet capability as a courtesy to help you keep your member information handy. It doesn’t mean we endorse or recommend this service. If you choose to use this service to store your member ID card, you agree that:\")]")
    private WebElement wallet_disclaimer_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We do not control or operate this service.\")]")
    private WebElement wallet_disclaimer_bullet_1;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We aren’t responsible or liable for the performance, content, or security of this service.\")]")
    private WebElement wallet_disclaimer_bullet_2;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You are responsible to read the privacy statements and terms of use on the applications and sites you use/ visit to understand their individual privacy practices.\")]")
    private WebElement wallet_disclaimer_bullet_3;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We are not responsible or liable for an error, loss or damage associated with your use of this service.\")]")
    private WebElement wallet_disclaimer_bullet_4;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We do not have access to this service provider.\")]")
    private WebElement wallet_disclaimer_bullet_5;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You are responsible for updating your member ID card in the wallet if your information changes.\")]")
    private WebElement wallet_disclaimer_bullet_6;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You control who has access to your wallet.\")]")
    private WebElement wallet_disclaimer_bullet_7;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We are not liable for any unauthorized use or disclosure of your member ID card.\")]")
    private WebElement wallet_disclaimer_bullet_8;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Accept\"]/android.widget.TextView")
    private WebElement wallet_disclaimer_accept_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Cancel\"]/android.widget.TextView")
    private WebElement wallet_disclaimer_cancel_button;

    // ------ GOOGLE WALLET ----- //
    @AndroidFindBy(className = "android.widget.Button")
    private WebElement add_card_toWallet;
    @AndroidFindBy(xpath = "//*[@text='Added to Wallet']")
    private WebElement card_added_toWallet;
    @AndroidFindBy(xpath = "//*[@text= 'Remove']")
    private WebElement remove_card_fromWallet;
    // ------ GOOGLE WALLET ----- //

    // ----- SHARE ----- //
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"android:id/icon\"]")
    private WebElement print_share_option;
    @AndroidFindBy(id = "com.android.printspooler:id/page_content")
    private WebElement pdf_file;
    // ----- SHARE ----- //


    public WebElement getMember_name() {
        return member_name;
    }

    public WebElement getMember_id() {
        return member_id;
    }

    public WebElement getGroup_name() {
        return group_name;
    }

    public WebElement getGroup_id() {
        return group_id;
    }

    public WebElement getLegal_disclosure() {
        return legal_disclosure;
    }

    public WebElement getNetwork_name_footer_text() {
        return network_name_footer_text;
    }

    public WebElement getDental_coverage_text() {
        return dental_coverage_text;
    }

    public WebElement getClaim_text_title() {
        return claim_text_title;
    }

    public WebElement getClaim_text_pobox() {
        return claim_text_pobox;
    }

    public WebElement getElectronic_claims_payor() {
        return electronic_claims_payor;
    }

    public WebElement getElectronic_claim_phone() {
        return electronic_claim_phone;
    }

    public WebElement getBottom_disclaimer_1() {
        return bottom_disclaimer_1;
    }

    public WebElement getGetBottom_disclaimer_2() {
        return getBottom_disclaimer_2;
    }

    public WebElement getShare_button() {
        return share_button;
    }

    public WebElement getWallet_button() {
        return wallet_button;
    }

    public WebElement getWallet_disclaimer_title() {
        return wallet_disclaimer_title;
    }

    public WebElement getWallet_disclaimer_text() {
        return wallet_disclaimer_text;
    }

    public WebElement getWallet_disclaimer_bullet_1() {
        return wallet_disclaimer_bullet_1;
    }

    public WebElement getWallet_disclaimer_bullet_2() {
        return wallet_disclaimer_bullet_2;
    }

    public WebElement getWallet_disclaimer_bullet_3() {
        return wallet_disclaimer_bullet_3;
    }

    public WebElement getWallet_disclaimer_bullet_4() {
        return wallet_disclaimer_bullet_4;
    }

    public WebElement getWallet_disclaimer_bullet_5() {
        return wallet_disclaimer_bullet_5;
    }

    public WebElement getWallet_disclaimer_bullet_6() {
        return wallet_disclaimer_bullet_6;
    }

    public WebElement getWallet_disclaimer_bullet_7() {
        return wallet_disclaimer_bullet_7;
    }

    public WebElement getWallet_disclaimer_bullet_8() {
        return wallet_disclaimer_bullet_8;
    }

    public WebElement getWallet_disclaimer_accept_button() {
        return wallet_disclaimer_accept_button;
    }

    public WebElement getWallet_disclaimer_cancel_button() {
        return wallet_disclaimer_cancel_button;
    }

    public WebElement getAdd_card_toWallet() {
        return add_card_toWallet;
    }

    public WebElement getCard_added_toWallet() {
        return card_added_toWallet;
    }

    public WebElement getPrint_share_option() {
        return print_share_option;
    }

    public WebElement getPdf_file() {
        return pdf_file;
    }

    public WebElement getRemove_card_fromWallet() {
        return remove_card_fromWallet;
    }
}
