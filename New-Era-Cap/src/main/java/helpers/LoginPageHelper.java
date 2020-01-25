package helpers;

import generic.BaseHelper;
import lombok.extern.log4j.Log4j;
import pages.LoginPage;

import static general.GeneralData.softAssertions;

@Log4j
public class LoginPageHelper extends BaseHelper<LoginPage> {
    public LoginPageHelper() {
        super(new LoginPage());
    }

    public LoginPageHelper filledFirstNameField(String fName) {
        filledField(getPage().getFirstNameField(), fName);
        return this;
    }

    public LoginPageHelper filledLastNameField(String lName) {
        filledField(getPage().getLastNameField(), lName);
        return this;
    }

    public LoginPageHelper filledEmailField(String email) {
        filledField(getPage().getEmailField(), email);
        return this;
    }

    public LoginPageHelper filledPasswordField(String pswd) {
        filledField(getPage().getPasswordField(), pswd);
        return this;
    }

    public LoginPageHelper filledConfirmPasswordField(String pswd) {
        filledField(getPage().getConfirmPasswordField(), pswd);
        return this;
    }

    public LoginPageHelper checkReceiveCheckboxWork() {
        getPage().getReceiveCheckbox().isDisplayed();
        getPage().getReceiveCheckbox().click();
        return this;
    }

    public void clickRegistrationBtn() {
        getPage().getRegisterButton().isDisplayed();
        getPage().getRegisterButton().click();
        log.info("'Registration' button was clicked");
    }

    public void registration(String name, String lName, String email, String password, String confPassword) {
        filledFirstNameField(name);
        filledLastNameField(lName);
        filledEmailField(email);
        filledPasswordField(password);
        filledConfirmPasswordField(confPassword);
        checkReceiveCheckboxWork();
        clickRegistrationBtn();
    }

    public void checkRegistrationError() {
        softAssertions.assertThat(getPage().getErrorPopUp())
                .as("Registration pop up not found")
                .isNotNull();
        softAssertions.assertThat(getPage().getErrorPopUp().getText())
                .as("Registration pop-up has incorrect text")
                .isEqualTo("Please correct the errors below.");
    }

    public void checkExistEmailMessage() {
        softAssertions.assertThat(getPage().getExistEmailMessage())
                .as("Error message not found")
                .isNotNull();
        softAssertions.assertThat(getPage().getExistEmailMessage().getAttribute("innerHTML"))
                .as("Error message about exist email has incorrect text")
                .isEqualTo("\n                              Please enter a valid e-mail address");
    }

    public void checkLogInError() {
        softAssertions.assertThat(getPage().getErrorPopUp())
                .as("Log in pop up not found")
                .isNotNull();
        softAssertions.assertThat(getPage().getErrorPopUp().getText())
                .as("Log in pop-up has incorrect text")
                .isEqualTo("Your username or password was incorrect.");
    }

    public void checkResetPasswordMessage() {
        softAssertions.assertThat(getPage().getErrorPopUp())
                .as("Reset pop up not found")
                .isNotNull();
        softAssertions.assertThat(getPage().getErrorPopUp().getAttribute("innerHTML"))
                .as("Reset pop-up has incorrect text")
                .isEqualTo("Password reset instructions have been sent to your e-mail address.");
    }

    public void checkAlertEnterValidEmail() {
        softAssertions.assertThat(getPage().getAlertEnterValidEmail())
                .as("Alert message not found")
                .isNotNull();
        softAssertions.assertThat(getPage().getAlertEnterValidEmail().getAttribute("innerHTML"))
                .as("Alert has incorrect message")
                .isEqualTo("\n                              Please enter a valid e-mail address");
    }

    public void logIn(String email, String password) {
        filledField(getPage().getUserEmailAddressField(), email);
        filledField(getPage().getUserPasswordField(), password);
        getPage().getLoginFormBtn().click();
    }

    public LoginPageHelper restPassword(String email) {
        getPage().getResetPasswordLink().click();
        filledField(getPage().getEmailForResetPswdField(), email);
        getPage().getResetPasswordButton().click();
        return this;
    }
}
