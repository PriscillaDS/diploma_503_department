package newEraCap.login;

import helpers.CoverPageHelper;
import helpers.LoginPageHelper;
import newEraCap.BaseTest;
import org.testng.annotations.Test;

import static general.GeneralData.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAscii;

public class AbilityToRegistrant extends BaseTest {
    private CoverPageHelper coverPageHelper;
    private LoginPageHelper loginPageHelper;

    @Test(groups = "Registration", description = "Check ability to registrant with short correct data")
    public void correctShortRegistration() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, VALID_SHORT_LAST_NAME, getValidEmail(), VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        coverPageHelper = new CoverPageHelper();
        coverPageHelper.isOnPage();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability to registrant with long correct data")
    public void correctLongRegistration() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_LONG_FIRST_NAME, VALID_LONG_LAST_NAME, getValidEmail(), VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        coverPageHelper = new CoverPageHelper();
        coverPageHelper.isOnPage();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check registration with empty fields")
    public void registrationWithEmptyData() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", "", "", "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check registration with only first name")
    public void registrationWithOnlyFirstName() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, "", "", "", "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with only last name")
    public void registrationWithOnlyLastName() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", VALID_SHORT_LAST_NAME, "", "", "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with only valid email")
    public void registrationWithOnlyValidEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", getValidEmail(), "", "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with only short password")
    public void registrationWithOnlyPassword() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", "", VALID_SHORT_PASSWORD, "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with only confirm password")
    public void registrationWithOnlyConfirmPassword() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", "", "", VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with only passwords")
    public void registrationWithOnlyPasswords() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", "", VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }


    @Test(groups = "Registration", description = "Check ability register user with empty last name and email ")
    public void registrationWithEmptyLastNameAndEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, "", "", VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with empty email and first name")
    public void registrationWithEmptyFirstNameAndEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", VALID_SHORT_LAST_NAME, "", VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with empty last and first name")
    public void registrationWithEmptyFirstAndLastName() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration("", "", getValidEmail(), VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with empty last name")
    public void registrationWithEmptyLastName() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, "", getValidEmail(), VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with empty confirm password")
    public void registrationWithEmptyConfirmPassword() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, VALID_SHORT_FIRST_NAME, getValidEmail(), VALID_SHORT_PASSWORD, "");
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registration", description = "Check ability register user with incorrect confirm password")
    public void registrationWithIncorrectConfirmPassword() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, VALID_SHORT_FIRST_NAME, getValidEmail(), VALID_SHORT_PASSWORD, VALID_SHORT_PASSWORD + randomAscii(1));
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }

    @Test(groups = "Registrtion", description = "Check ability register user with existing email and password")
    public void registrationWithNewDataAndExistingEmailAndPassword() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.registration(VALID_SHORT_FIRST_NAME, VALID_SHORT_FIRST_NAME, EXISTING_EMAIL, EXISTING_PASSWORD, EXISTING_PASSWORD);
        loginPageHelper.checkRegistrationError();
        softAssertions.assertAll();
    }


}
