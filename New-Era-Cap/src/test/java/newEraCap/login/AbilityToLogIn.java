package newEraCap.login;

import helpers.CoverPageHelper;
import helpers.LoginPageHelper;
import newEraCap.BaseTest;
import org.testng.annotations.Test;

import static general.GeneralData.*;

public class AbilityToLogIn extends BaseTest {
    private CoverPageHelper coverPageHelper;
    private LoginPageHelper loginPageHelper;

    @Test(description = "Verify ability to login with correct data")
    public void correctLogIn() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn(EXISTING_EMAIL, EXISTING_PASSWORD);
        coverPageHelper = new CoverPageHelper();
        coverPageHelper.isOnPage();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with non exist data")
    public void logInWithNonExistData() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn(getValidEmail(), VALID_SHORT_PASSWORD);
        loginPageHelper.checkLogInError();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with non existing email and existing password ")
    public void logInWithNonExistingEmailAndExistingPswd() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn(getValidEmail(), EXISTING_PASSWORD);
        loginPageHelper.checkLogInError();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with existing email and valid password ")
    public void logInWithExistingEmailAndInvalidPswd() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn(EXISTING_EMAIL, INVALID_LONG_PASSWORD);
        loginPageHelper.checkLogInError();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with empty data")
    public void logInWithEmptyData() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn("","");
        loginPageHelper.checkLogInError();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with empty password and existing email")
    public void logInWithExistingEmailAndEmptyPswd() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn(EXISTING_EMAIL, "");
        loginPageHelper.checkLogInError();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to log in with empty email and existing password")
    public void logInWithEmptyEmailAndExistingPswd() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.logIn("", EXISTING_PASSWORD);
        loginPageHelper.checkLogInError();
        loginPageHelper.checkExistEmailMessage();
        softAssertions.assertAll();
    }
}
