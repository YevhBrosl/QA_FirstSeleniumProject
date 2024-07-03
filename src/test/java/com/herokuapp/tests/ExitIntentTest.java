package com.herokuapp.tests;

import com.herokuapp.pages.ExitIntentPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExitIntentTest extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getExitIntent();
    }

    @Test
    public void exitViewportTest() {
        new ExitIntentPage(driver).exitViewport();
                //.verifyReturnToExitIntentPage("https://the-internet.herokuapp.com/exit_intent");
    }
}
