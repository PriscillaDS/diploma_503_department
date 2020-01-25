package newEraCap.login;

import helpers.LoginPageHelper;
import newEraCap.BaseTest;
import org.testng.annotations.Test;

import static general.GeneralData.*;

public class AbilityToResetPassword extends BaseTest {
    LoginPageHelper loginPageHelper;

    @Test(description = "Check ability to reset password with correct email")
    public void resetPasswordWithExistEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.restPassword(EXISTING_EMAIL);
        loginPageHelper.checkResetPasswordMessage();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to reset password with incorrect email")
    public void resetPasswordWithIncorrectEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.restPassword(getValidEmail());
        loginPageHelper.checkResetPasswordMessage();
        softAssertions.assertAll();
    }

    @Test(description = "Check ability to rest password with empty email")
    public void resetPasswordWithEmptyEmail() {
        loginPageHelper = new LoginPageHelper();
        loginPageHelper.openPage();
        loginPageHelper.restPassword("");
        loginPageHelper.checkAlertEnterValidEmail();
        softAssertions.assertAll();
    }
}
