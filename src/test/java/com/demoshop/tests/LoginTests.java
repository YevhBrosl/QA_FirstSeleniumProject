package com.demoshop.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isAccountLinkPresentBeforeRegistration()) {
            app.getUser().clickOnLogOutButton();
        }
    }
    @Test
    public void loginPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        app.getUser().clickOnLoginLink();
        app.getUser().fillOutLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        softAssert.assertTrue(app.getUser().isLogOutButtonPresent());
        softAssert.assertTrue(app.getUser().isAccountLinkPresent(UserData.EMAIL));
        softAssert.assertAll();
    }
    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillOutLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isValidationErrorMessagePresent());
    }
}
