package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JavaScriptAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertTests extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavaScriptAlerts();
    }

    @Test
    public void jsAlertTest() {
        new JavaScriptAlertsPage(driver).jsAlert()
                .verifyResult("successfully");
    }

    @Test
    public void jsConfirmTest() {
        new JavaScriptAlertsPage(driver).selectResult("Cancel")
                .verifyConfirmResult("Cancel");
    }

    @Test
    public void jsPromptTest() {
        new JavaScriptAlertsPage(driver).sendPrompt("Hello, Alert!")
                .verifyPrompt("Hello, Alert!");
    }

}
