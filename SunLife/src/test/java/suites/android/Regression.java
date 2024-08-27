package suites.android;

import commomUtils.AndroidActions;
import org.testng.annotations.AfterMethod;
import utils.AndroidBase;

import java.io.FileNotFoundException;

public class Regression extends AndroidBase {

    @AfterMethod(alwaysRun = true)
    public void resetting() throws FileNotFoundException {
        new AndroidActions(driver).resetApp();
    }


//    Can't log in using FE
//    Can't create account using FE
//    Mobile App > Android - Incorrect password gets cached/stored preventing login
//    Can't create account or login using FE with dev tenent env
//    Mobile App > Create account button disabled despite all criteria being met
//    Change password only working once
//    Log in button enabled (code) with invalid email input.
//    Mobile App > Android - Employee reported password reset flow is not working
//    Create account and Change password (more screen) - App is not accepting 64 characters
//    Session time out modal not available
//    App logging user out after > 20min < 30min
//    Mobile App > Wallet Disclaimer - needs to scroll
//    ID Card - Shared pdf file not bringing ID CARD
//    Phone and website tags still visible
//    Incorrect usernames display on "More" tab
//    Mobile App > Fix typos
//    Mobile App > Login - Email input field does not allow user to delete all text
//    Mobile App > Google Wallet - Fields are duplicated on Pass Details
//    [Only Android] ID Card - App crashes when user press google wallet button.
//    Login - App gets stuck when user logs in
//    More Menu - Change password, password requirements still green when user changes its password.
//    Mobile Ap > View Claims - date of service date format incorrect
//    Create account - Button is enabled with terms and consent not checked.
//    Mobile App > Home - updates required based on mockups
//    Mobile App > ID Card - Missing Wallet Disclaimer (iOS + Android)
//    Mobile App > ID Card - Issues with PDF (Apple + Android)
//    EOB - Share button not working to export PDF file
//    Mobile App > EOB View - issue loading PDF / file shared is corrupt (Android only)
//    Deductibles & maximums > Displaying error message despite having data
//    Mobile App > View Claims - Cannot share EOBs (iOS only)
//    Mobile app: Digital ID export to PDF adds an empty first page on android
//    Mobile App > Add to Google Wallet does not work on Android
//    Deductible & Maximums - accumulators displaying same label text for different coverage level.
//    Home - Policy number same value as policy name
//    Okta not sending user back to app
//    View claims / EOB file - Android is crashing when user tries press EOB button to get pdf file.
//    Mobile app: Share button on EoB doesn't work
//    EoB Defect: EoB button in the mobile app is not enabled
//    Create account - App gets stuck when user tries to create account with email already in use
//    View claims - Missing hint key content
//    Create account - Password matching confirmation content key is displayed fixed
//    More menu tab - Change password is crashing the app.
//    Mobile app > Validate member SSN method - cannot click Verify now button
//    Deductibles & Maximums - Bottom menu not available
//    Home - After login user lands at blank home screen (RANDOM)
//    Can't change password
//    500 screen message not popping up
//    Deductiable & Maximums - Single member is shown duplicated.
//    Mobile app > Login screen - displaying Title case content
//    Mobile app: Add elements for View Claims, Nav Menu and Create Account Screen
//    Mobile app: View Claims defects
//    DAPI Claims: Order the claims in the reverse chronological order
//    Login - Loading icon not showing up
//    Mobile app > Login screen - Find a dentist link too close to terms and conditions
//    Create account - It's possible to create account as dependent
//    Error states Modal with wrong colors
//    Verify Member: Text Entry is incorrect and obscures SSN field during tabbing into that field with keyboard open
//    App keeps old cache when new user logs in.
//    Login - It is not possible to login back
//    Verify member - Modal alert buttons are not aligned to the right
//    Verify member - Verify button disabled color is invalid.
//    More menu tab - Change password not working
//    More menu tab - Change password not accepting "@" as special char
//    More menu tab - Telephone numbers are null
//    More Menu -> Change Password and back causes UI weirdness
//    Create account - After creating account when user logs out, app lands at create account screen.
//    Create account - Disclosure links not opening.
//    [Only Android] Create account - Terms and consent disclosure text misaligned.
//    Verify member - App validates correct member data as wrong.
//    Verify member - Input persists even changing screen.
//    Verify member - Need help phone number with wrong format.
//    Verify member - Try again button of failed to validate modal should close modal.
//    Verify member - Verify button enabled with empty fields
//    Login - error_toomanyattempts_modal not popping up after 3 attempts.
//    Login - Find a dentist on sunlife.com link missing
//    Login - Login button enabled with wrong email format input.
//    Login - Failed login modal not closing
//    Login (Only Android) - Failed login modal does not pop up.
}
