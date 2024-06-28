package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.HoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTests extends TestBase1{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHovers();
    }

    @Test
    public void viewProfileAfterHoveringTest() {
        new HoverPage(driver).hoverOverAvatar(0).verifyName("user1")
                .viewProfile().verifyProfile("Not Found");
    }
}
