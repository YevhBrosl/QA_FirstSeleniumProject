package com.demoshop.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import com.demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresent()) {
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

    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void createAccountPositiveTestFromDataProvider(String firstName, String lastName, String email,
                                                          String password, String confirmPassword) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillOutRegistrationForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test(dataProvider = "addNewUserFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountPositiveTestFromDataProviderWithCsv(String firstName, String lastName, String email,
                                                          String password, String confirmPassword) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillOutRegistrationForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }
}
