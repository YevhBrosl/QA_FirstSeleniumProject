package com.demoshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        //click on Login link
        click(By.cssSelector(".ico-login"));
        //enter email
        type(By.cssSelector("#Email"), "seba@yh.com");
        //enter password
        type(By.cssSelector("#Password"), "12345Qw$");
        //click on login button
        click(By.cssSelector(".login-button"));
        //assert Log Out button is present
        softAssert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
        //assert account link is present
        //softAssert.assertTrue(isElementPresent(By.xpath("//a[.='seba@yh.com']")));
        softAssert.assertTrue(isTextPresent(By.cssSelector(".header-links-wrapper:nth-child(2)[href='/customer/info']"), "seba@yh.com"));
        softAssert.assertAll();
    }

}
