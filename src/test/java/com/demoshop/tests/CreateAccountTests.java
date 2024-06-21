package com.demoshop.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isAccountLinkPresentBeforeRegistration()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test(enabled = false)
    public void createAccountPositiveTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillOutRegistrationForm(new User()
                .setFirstName(UserData.NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test
    public void createExistingAccountNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillOutRegistrationForm(new User()
                .setFirstName(UserData.NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isValidationErrorMessagePresent());
    }
}
