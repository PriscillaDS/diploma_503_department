package pages;

import generic.BasePage;
import generic.annotation.PagePath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@PagePath("login")
public class LoginPage extends BasePage {
    public LoginPage() {
        setLoadableElement(registerButton);
    }

    private By loginFormBtn = By.id("loginFormBtn");
    private By firstNameField = By.name("firstName");
    private By firstNameErrorField = By.id("firstName.errors");
    private By lastNameField = By.name("lastName");
    private By emailField = By.name("email");
    private By existEmailMessage = By.id("email.errors");
    private By passwordField = By.name("pwd");
    private By confirmPasswordField = By.name("checkPwd");
    private By receiveCheckbox = By.cssSelector("label.nwer-checkbox--custom");
    private By registerButton = By.id("registerFormBtn");

    private By userEmailAddressField = By.id("j_username");
    private By userPasswordField = By.id("j_password");
    private By signInButton = By.id("loginFormBtn");
    private By loginWithFacebookButton = By.id("FBloginFormBtn");

    private By errorPopUp = By.className("alert-plain-message");

    private By resetPasswordLink = By.className("js-password-forgotten");
    private By emailForResetPswdField = By.id("forgottenPwd.email");
    private By resetPasswordButton = By.cssSelector("#forgottenPwdForm > div.control-group > button");

    private By alertEnterValidEmail = By.id("email.errors");

    public WebElement getAlertEnterValidEmail() {
        return driver().findElement(alertEnterValidEmail);
    }

    public WebElement getResetPasswordButton() {
        return driver().findElement(resetPasswordButton);
    }

    public WebElement getEmailForResetPswdField() {
        waitLoadableElement(emailForResetPswdField);
        return driver().findElement(emailForResetPswdField);
    }

    public WebElement getExistEmailMessage() {
        return driver().findElement(existEmailMessage);
    }

    public WebElement getErrorPopUp() {
        waitLoadableElement(errorPopUp);
        return driver().findElement(errorPopUp);}

    public WebElement getLoginFormBtn() {
        return driver().findElement(loginFormBtn);
    }

    public WebElement getFirstNameField() {
        return driver().findElement(firstNameField);
    }

    public WebElement getFirstNameErrorField() {
        return driver().findElement(firstNameErrorField);
    }

    public WebElement getLastNameField() {
        return driver().findElement(lastNameField);
    }

    public WebElement getEmailField() {
        return driver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return driver().findElement(confirmPasswordField);
    }

    public WebElement getReceiveCheckbox() {
        return driver().findElement(receiveCheckbox);
    }

    public WebElement getRegisterButton() {
        return driver().findElement(registerButton);
    }

    public WebElement getUserEmailAddressField() {
        return driver().findElement(userEmailAddressField);
    }

    public WebElement getUserPasswordField() {
        return driver().findElement(userPasswordField);
    }

    public WebElement getResetPasswordLink() {
        return driver().findElement(resetPasswordLink);
    }

    public WebElement getSignInButton() {
        return driver().findElement(signInButton);
    }

    public WebElement getLoginWithFacebookButton() {
        return driver().findElement(loginWithFacebookButton);
    }

//    public WebElement getResetPasswordPopUp() {
//        return driver().findElement(resetPasswordPopUp);
//    }


}
