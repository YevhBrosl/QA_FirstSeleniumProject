package com.demoshop.fw;

import com.demoshop.fw.BaseHelper;
import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector("#register-button"));
    }

    public void fillOutRegistrationForm(User user) {
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".ico-register"));
    }

    public boolean isAccountLinkPresent(String userEmail) {
        return isTextPresent(By.cssSelector(".header-links-wrapper:nth-child(2) [href='/customer/info']"), userEmail);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

    public void fillOutLoginForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }


    public void clickOnLogOutButton() {
        click(By.cssSelector(".ico-logout"));
    }

    public boolean isAccountLinkPresentBeforeRegistration() {
        return isElementPresent(By.cssSelector(".header-links-wrapper:nth-child(2) [href='/customer/info']"));
    }

    public boolean isValidationErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }
}
