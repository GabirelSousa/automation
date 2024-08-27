package iosPages;

import commomUtils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import commomUtils.IOSActions;

import java.io.FileNotFoundException;

public class CardIDPage extends AppiumUtils {

    //IOSDriver driver;

    public CardIDPage(AppiumDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ----- FRONT ----- //
    @iOSXCUITFindBy(accessibility = "id-card-insured-member-name")
    private WebElement member_name;
    @iOSXCUITFindBy(accessibility = "id-card-insured-member-id")
    private WebElement member_id;
    @iOSXCUITFindBy(accessibility = "id-card-group-name")
    private WebElement group_name;
    @iOSXCUITFindBy(accessibility = "id-card-group-id")
    private WebElement group_id;
    @iOSXCUITFindBy(accessibility = "id-card-legal-disclosure")
    private WebElement legal_disclosure;

    // ----- BACK ----- //
    @iOSXCUITFindBy(accessibility = "id-card-network-name-footer-text")
    private WebElement network_name_footer_text;
    @iOSXCUITFindBy(accessibility = "id-card-dental-paragraph-text")
    private WebElement dental_coverage_text;
    @iOSXCUITFindBy(accessibility = "id-card-claims-text")
    private WebElement claim_text_title;
    @iOSXCUITFindBy(accessibility = "id-card-claims-pobox")
    private WebElement claim_text_pobox;
    @iOSXCUITFindBy(accessibility = "id-card-electronic-claims")
    private WebElement electronic_claims_payor;
    @iOSXCUITFindBy(accessibility = "id-card-electronic-claims-phone")
    private WebElement electronic_claim_phone;
    @iOSXCUITFindBy(accessibility = "Sun Life's dental networks include its affiliate, Dental Health Alliance®, L.L.C. (DHA®), and dentists under access arrangements with other dental networks.")
    private WebElement bottom_disclaimer_1;
    @iOSXCUITFindBy(accessibility = "© 2024 Sun Life Assurance Company of Canada, Wellesley Hills, MA 02481. All rights reserved. The Sun Life name and logo are registered trademarks of Sun Life Assurance Company of Canada. Visit us at www.sunlife.com/us.")
    private WebElement getBottom_disclaimer_2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"\uDB82\uDF93 SHARE/SAVE\"]")
    private WebElement share_button;
    @iOSXCUITFindBy(accessibility = "print")
    private WebElement share_print_option;


    // ----- APPLE WALLET ----- //
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Add to Apple Wallet Button\"])[2]")
    private WebElement wallet_button;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sun Life Dental ID Card\"]")
    private WebElement apple_wallet_title;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]")
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

    @iOSXCUITFindBy(accessibility = "Wallet Disclaimer")
    private WebElement wallet_disclaimer_title;
    @iOSXCUITFindBy(accessibility = "Sun Life provides the wallet capability as a courtesy to help you keep your member information handy. It doesn’t mean we endorse or recommend this service. If you choose to use this service to store your member ID card, you agree that:")
    private WebElement wallet_disclaimer_text;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We do not control or operate this service.\"]")
    private WebElement wallet_disclaimer_bullet_1;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We aren’t responsible or liable for the performance, content, or security of this service.\"]")
    private WebElement wallet_disclaimer_bullet_2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• You are responsible to read the privacy statements and terms of use on the applications and sites you use/ visit to understand their individual privacy practices.\"]")
    private WebElement wallet_disclaimer_bullet_3;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• We are not responsible or liable for an error, loss or damage associated with your use of this service.\"]")
    private WebElement wallet_disclaimer_bullet_4;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• We do not have access to this service provider.\"]")
    private WebElement wallet_disclaimer_bullet_5;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• You are responsible for updating your member ID card in the wallet if your information changes.\"]")
    private WebElement wallet_disclaimer_bullet_6;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"• You control who has access to your wallet.\"]")
    private WebElement wallet_disclaimer_bullet_7;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"• We are not liable for any unauthorized use or disclosure of your member ID card.\"]")
    private WebElement wallet_disclaimer_bullet_8;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Accept\"])[2]")
    private WebElement wallet_disclaimer_accept_button;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Cancel\"])[2]")
    private WebElement wallet_disclaimer_cancel_button;

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

    public WebElement getShare_print_option() {
        return share_print_option;
    }

    public WebElement getWallet_button() {
        return wallet_button;
    }

    public WebElement getApple_wallet_title() {
        return apple_wallet_title;
    }

    public WebElement getApple_wallet_add_button() {
        return apple_wallet_add_button;
    }

    public WebElement getApple_wallet_card() {
        return apple_wallet_card;
    }

    public WebElement getApple_wallet_group_name() {
        return apple_wallet_group_name;
    }

    public WebElement getApple_wallet_coverage() {
        return apple_wallet_coverage;
    }

    public WebElement getApple_wallet_group_number() {
        return apple_wallet_group_number;
    }

    public WebElement getApple_wallet_network() {
        return apple_wallet_network;
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
}
