package pages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class IDCard extends AppiumUtils {

    public IDCard(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    // ----- FRONT ----- //
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-insured-member-name")
    @iOSXCUITFindBy(accessibility = "id-card-insured-member-name")
    private WebElement member_name;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-insured-member-id")
    @iOSXCUITFindBy(accessibility = "id-card-insured-member-id")
    private WebElement member_id;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-group-name")
    @iOSXCUITFindBy(accessibility = "id-card-group-name")
    private WebElement group_name;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-group-id")
    @iOSXCUITFindBy(accessibility = "id-card-group-id")
    private WebElement group_id;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-legal-disclosure")
    @iOSXCUITFindBy(accessibility = "id-card-legal-disclosure")
    private WebElement legal_disclosure;
    // ----- FRONT ----- //

    // ----- BACK ----- //
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-network-name-footer-text")
    @iOSXCUITFindBy(accessibility = "id-card-network-name-footer-text")
    private WebElement network_name_footer_text;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-dental-paragraph-text")
    @iOSXCUITFindBy(accessibility = "id-card-dental-paragraph-text")
    private WebElement dental_coverage_text;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-claims-text")
    @iOSXCUITFindBy(accessibility = "id-card-claims-text")
    private WebElement claim_text_title;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-claims-pobox")
    @iOSXCUITFindBy(accessibility = "id-card-claims-pobox")
    private WebElement claim_text_pobox;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-electronic-claims")
    @iOSXCUITFindBy(accessibility = "id-card-electronic-claims")
    private WebElement electronic_claims_payor;
    @AndroidFindBy(id = "com.sunlifeus:id/id-card-electronic-claims-phone")
    @iOSXCUITFindBy(accessibility = "id-card-electronic-claims-phone")
    private WebElement electronic_claim_phone;
    @AndroidFindBy(xpath = "*/android.view.ViewGroup[4]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Sun Life's dental networks include its affiliate, Dental Health Alliance®, L.L.C. (DHA®), and dentists under access arrangements with other dental networks.")
    private WebElement bottom_disclaimer_1;
    @AndroidFindBy(xpath = "*/android.view.ViewGroup[5]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "© 2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at www.sunlife.com/us.")
    private WebElement getBottom_disclaimer_2;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"\uDB82\uDF93, SHARE/SAVE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"\uDB82\uDF93 SHARE/SAVE\"]")
    private WebElement share_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add to Google Wallet Button\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Add to Apple Wallet Button\"])[2]")
    private WebElement wallet_button;
    // ----- BACK ----- //

    // ------ GOOGLE WALLET ----- //
    @AndroidFindBy(id = "com.google.android.gms:id/SaveCard")
    private WebElement save_card_google;
    @AndroidFindBy(id = "com.google.android.gms:id/SaveCardHeaderTitle")
    private WebElement save_card_google_name_holder;
    @AndroidFindBy(id = "android:id/profile_pager")
    private WebElement content_preview_pager;
    @AndroidFindBy(id = "com.google.android.gms:id/MainPayActivityView")
    private WebElement add_card_wallet_screen;
    @AndroidFindBy(id = "com.google.android.gms:id/OpenAppButton")
    private WebElement open_google_wallet_button;
    @AndroidFindBy(id = "com.google.android.gms:id/OverflowIcon")
    private WebElement more_options_menu;
    // ------ GOOGLE WALLET ----- //

    // ----- APPLE WALLET ----- //
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sun Life Dental ID Card\"]")
    private WebElement apple_wallet_title;
    @iOSXCUITFindBy(accessibility = "Add")
    private WebElement apple_wallet_add_button;
    @iOSXCUITFindBy(accessibility = "SunLife")
    private WebElement apple_wallet_card;
    @iOSXCUITFindBy(accessibility = "GROUP NAME")
    private WebElement apple_wallet_group_name;
    @iOSXCUITFindBy(accessibility = "COVERAGE")
    private WebElement apple_wallet_coverage;
    @iOSXCUITFindBy(accessibility = "GROUP NUMBER")
    private WebElement apple_wallet_group_number;
    @iOSXCUITFindBy(accessibility = "NETWORK")
    private WebElement apple_wallet_network;
    // ----- APPLE WALLET ----- //

    // ----- DISCLAIMER ----- //
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"Wallet Disclaimer\")]")
    @iOSXCUITFindBy(accessibility = "Wallet Disclaimer")
    private WebElement wallet_disclaimer_title;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"Sun Life provides the wallet capability as a courtesy to help you keep your member information handy. It doesn’t mean we endorse or recommend this service. If you choose to use this service to store your member ID card, you agree that:\")]")
    @iOSXCUITFindBy(accessibility = "Sun Life provides the wallet capability as a courtesy to help you keep your member information handy. It doesn’t mean we endorse or recommend this service. If you choose to use this service to store your member ID card, you agree that:")
    private WebElement wallet_disclaimer_text;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We do not control or operate this service.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We do not control or operate this service.\"]")
    private WebElement wallet_disclaimer_bullet_1;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We aren’t responsible or liable for the performance, content, or security of this service.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We aren’t responsible or liable for the performance, content, or security of this service.\"]")
    private WebElement wallet_disclaimer_bullet_2;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You are responsible to read the privacy statements and terms of use on the applications and sites you use/ visit to understand their individual privacy practices.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• You are responsible to read the privacy statements and terms of use on the applications and sites you use/ visit to understand their individual privacy practices.\"]")
    private WebElement wallet_disclaimer_bullet_3;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We are not responsible or liable for an error, loss or damage associated with your use of this service.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We are not responsible or liable for an error, loss or damage associated with your use of this service.\"]")
    private WebElement wallet_disclaimer_bullet_4;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We do not have access to this service provider.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• We do not have access to this service provider.\"]")
    private WebElement wallet_disclaimer_bullet_5;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You are responsible for updating your member ID card in the wallet if your information changes.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• You are responsible for updating your member ID card in the wallet if your information changes.\"]")
    private WebElement wallet_disclaimer_bullet_6;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• You control who has access to your wallet.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• You control who has access to your wallet.\"]")
    private WebElement wallet_disclaimer_bullet_7;
    @AndroidFindBy(xpath = "//android.widget.TextView[*contains(@text, \"• We are not liable for any unauthorized use or disclosure of your member ID card.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• We are not liable for any unauthorized use or disclosure of your member ID card.\"]")
    private WebElement wallet_disclaimer_bullet_8;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Accept\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Accept\"])[2]")
    private WebElement wallet_disclaimer_accept_button;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Cancel\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Cancel\"])[2]")
    private WebElement wallet_disclaimer_cancel_button;


    public WebElement getMember_name() {
        return member_name;
    }

    public void setMember_name(WebElement member_name) {
        this.member_name = member_name;
    }

    public WebElement getMember_id() {
        return member_id;
    }

    public void setMember_id(WebElement member_id) {
        this.member_id = member_id;
    }

    public WebElement getGroup_name() {
        return group_name;
    }

    public void setGroup_name(WebElement group_name) {
        this.group_name = group_name;
    }

    public WebElement getGroup_id() {
        return group_id;
    }

    public void setGroup_id(WebElement group_id) {
        this.group_id = group_id;
    }

    public WebElement getLegal_disclosure() {
        return legal_disclosure;
    }

    public void setLegal_disclosure(WebElement legal_disclosure) {
        this.legal_disclosure = legal_disclosure;
    }

    public WebElement getNetwork_name_footer_text() {
        return network_name_footer_text;
    }

    public void setNetwork_name_footer_text(WebElement network_name_footer_text) {
        this.network_name_footer_text = network_name_footer_text;
    }

    public WebElement getDental_coverage_text() {
        return dental_coverage_text;
    }

    public void setDental_coverage_text(WebElement dental_coverage_text) {
        this.dental_coverage_text = dental_coverage_text;
    }

    public WebElement getClaim_text_title() {
        return claim_text_title;
    }

    public void setClaim_text_title(WebElement claim_text_title) {
        this.claim_text_title = claim_text_title;
    }

    public WebElement getClaim_text_pobox() {
        return claim_text_pobox;
    }

    public void setClaim_text_pobox(WebElement claim_text_pobox) {
        this.claim_text_pobox = claim_text_pobox;
    }

    public WebElement getElectronic_claims_payor() {
        return electronic_claims_payor;
    }

    public void setElectronic_claims_payor(WebElement electronic_claims_payor) {
        this.electronic_claims_payor = electronic_claims_payor;
    }

    public WebElement getElectronic_claim_phone() {
        return electronic_claim_phone;
    }

    public void setElectronic_claim_phone(WebElement electronic_claim_phone) {
        this.electronic_claim_phone = electronic_claim_phone;
    }

    public WebElement getBottom_disclaimer_1() {
        return bottom_disclaimer_1;
    }

    public void setBottom_disclaimer_1(WebElement bottom_disclaimer_1) {
        this.bottom_disclaimer_1 = bottom_disclaimer_1;
    }

    public WebElement getGetBottom_disclaimer_2() {
        return getBottom_disclaimer_2;
    }

    public void setGetBottom_disclaimer_2(WebElement getBottom_disclaimer_2) {
        this.getBottom_disclaimer_2 = getBottom_disclaimer_2;
    }

    public WebElement getShare_button() {
        return share_button;
    }

    public void setShare_button(WebElement share_button) {
        this.share_button = share_button;
    }

    public WebElement getWallet_button() {
        return wallet_button;
    }

    public void setWallet_button(WebElement wallet_button) {
        this.wallet_button = wallet_button;
    }

    public WebElement getSave_card_google() {
        return save_card_google;
    }

    public void setSave_card_google(WebElement save_card_google) {
        this.save_card_google = save_card_google;
    }

    public WebElement getSave_card_google_name_holder() {
        return save_card_google_name_holder;
    }

    public void setSave_card_google_name_holder(WebElement save_card_google_name_holder) {
        this.save_card_google_name_holder = save_card_google_name_holder;
    }

    public WebElement getContent_preview_pager() {
        return content_preview_pager;
    }

    public void setContent_preview_pager(WebElement content_preview_pager) {
        this.content_preview_pager = content_preview_pager;
    }

    public WebElement getAdd_card_wallet_screen() {
        return add_card_wallet_screen;
    }

    public void setAdd_card_wallet_screen(WebElement add_card_wallet_screen) {
        this.add_card_wallet_screen = add_card_wallet_screen;
    }

    public WebElement getOpen_google_wallet_button() {
        return open_google_wallet_button;
    }

    public void setOpen_google_wallet_button(WebElement open_google_wallet_button) {
        this.open_google_wallet_button = open_google_wallet_button;
    }

    public WebElement getMore_options_menu() {
        return more_options_menu;
    }

    public void setMore_options_menu(WebElement more_options_menu) {
        this.more_options_menu = more_options_menu;
    }

    public WebElement getApple_wallet_title() {
        return apple_wallet_title;
    }

    public void setApple_wallet_title(WebElement apple_wallet_title) {
        this.apple_wallet_title = apple_wallet_title;
    }

    public WebElement getApple_wallet_add_button() {
        return apple_wallet_add_button;
    }

    public void setApple_wallet_add_button(WebElement apple_wallet_add_button) {
        this.apple_wallet_add_button = apple_wallet_add_button;
    }

    public WebElement getApple_wallet_card() {
        return apple_wallet_card;
    }

    public void setApple_wallet_card(WebElement apple_wallet_card) {
        this.apple_wallet_card = apple_wallet_card;
    }

    public WebElement getApple_wallet_group_name() {
        return apple_wallet_group_name;
    }

    public void setApple_wallet_group_name(WebElement apple_wallet_group_name) {
        this.apple_wallet_group_name = apple_wallet_group_name;
    }

    public WebElement getApple_wallet_coverage() {
        return apple_wallet_coverage;
    }

    public void setApple_wallet_coverage(WebElement apple_wallet_coverage) {
        this.apple_wallet_coverage = apple_wallet_coverage;
    }

    public WebElement getApple_wallet_group_number() {
        return apple_wallet_group_number;
    }

    public void setApple_wallet_group_number(WebElement apple_wallet_group_number) {
        this.apple_wallet_group_number = apple_wallet_group_number;
    }

    public WebElement getApple_wallet_network() {
        return apple_wallet_network;
    }

    public void setApple_wallet_network(WebElement apple_wallet_network) {
        this.apple_wallet_network = apple_wallet_network;
    }

    public WebElement getWallet_disclaimer_title() {
        return wallet_disclaimer_title;
    }

    public void setWallet_disclaimer_title(WebElement wallet_disclaimer_title) {
        this.wallet_disclaimer_title = wallet_disclaimer_title;
    }

    public WebElement getWallet_disclaimer_text() {
        return wallet_disclaimer_text;
    }

    public void setWallet_disclaimer_text(WebElement wallet_disclaimer_text) {
        this.wallet_disclaimer_text = wallet_disclaimer_text;
    }

    public WebElement getWallet_disclaimer_bullet_1() {
        return wallet_disclaimer_bullet_1;
    }

    public void setWallet_disclaimer_bullet_1(WebElement wallet_disclaimer_bullet_1) {
        this.wallet_disclaimer_bullet_1 = wallet_disclaimer_bullet_1;
    }

    public WebElement getWallet_disclaimer_bullet_2() {
        return wallet_disclaimer_bullet_2;
    }

    public void setWallet_disclaimer_bullet_2(WebElement wallet_disclaimer_bullet_2) {
        this.wallet_disclaimer_bullet_2 = wallet_disclaimer_bullet_2;
    }

    public WebElement getWallet_disclaimer_bullet_3() {
        return wallet_disclaimer_bullet_3;
    }

    public void setWallet_disclaimer_bullet_3(WebElement wallet_disclaimer_bullet_3) {
        this.wallet_disclaimer_bullet_3 = wallet_disclaimer_bullet_3;
    }

    public WebElement getWallet_disclaimer_bullet_4() {
        return wallet_disclaimer_bullet_4;
    }

    public void setWallet_disclaimer_bullet_4(WebElement wallet_disclaimer_bullet_4) {
        this.wallet_disclaimer_bullet_4 = wallet_disclaimer_bullet_4;
    }

    public WebElement getWallet_disclaimer_bullet_5() {
        return wallet_disclaimer_bullet_5;
    }

    public void setWallet_disclaimer_bullet_5(WebElement wallet_disclaimer_bullet_5) {
        this.wallet_disclaimer_bullet_5 = wallet_disclaimer_bullet_5;
    }

    public WebElement getWallet_disclaimer_bullet_6() {
        return wallet_disclaimer_bullet_6;
    }

    public void setWallet_disclaimer_bullet_6(WebElement wallet_disclaimer_bullet_6) {
        this.wallet_disclaimer_bullet_6 = wallet_disclaimer_bullet_6;
    }

    public WebElement getWallet_disclaimer_bullet_7() {
        return wallet_disclaimer_bullet_7;
    }

    public void setWallet_disclaimer_bullet_7(WebElement wallet_disclaimer_bullet_7) {
        this.wallet_disclaimer_bullet_7 = wallet_disclaimer_bullet_7;
    }

    public WebElement getWallet_disclaimer_bullet_8() {
        return wallet_disclaimer_bullet_8;
    }

    public void setWallet_disclaimer_bullet_8(WebElement wallet_disclaimer_bullet_8) {
        this.wallet_disclaimer_bullet_8 = wallet_disclaimer_bullet_8;
    }

    public WebElement getWallet_disclaimer_accept_button() {
        return wallet_disclaimer_accept_button;
    }

    public void setWallet_disclaimer_accept_button(WebElement wallet_disclaimer_accept_button) {
        this.wallet_disclaimer_accept_button = wallet_disclaimer_accept_button;
    }

    public WebElement getWallet_disclaimer_cancel_button() {
        return wallet_disclaimer_cancel_button;
    }

    public void setWallet_disclaimer_cancel_button(WebElement wallet_disclaimer_cancel_button) {
        this.wallet_disclaimer_cancel_button = wallet_disclaimer_cancel_button;
    }
}
