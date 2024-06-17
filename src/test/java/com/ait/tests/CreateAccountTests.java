package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createAccountPositiveTest() {
        //click on Register link
        click(By.cssSelector(".ico-register"));
        //enter name
        type(By.cssSelector("#FirstName"), "Sebastian");
        //enter last name
        type(By.cssSelector("#LastName"), "Smith");
        //enter email
        type(By.cssSelector("#Email"), "seba@yh.com");
        //enter password
        type(By.cssSelector("#Password"), "12345Qw$");
        //enter confirm password
        type(By.cssSelector("#ConfirmPassword"), "12345Qw$");
        //click on Register button
        click(By.cssSelector("#register-button"));
        //assert Log Out button is present
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
        //assert successful registration message is present
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")));
        //assert account link is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='seba@yh.com']")));
    }
}
