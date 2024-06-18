package com.demoshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {

        int i = new Random().nextInt(1000) + 1000;

        SoftAssert softAssert = new SoftAssert();
        //click on Register link
        click(By.cssSelector(".ico-register"));
        //enter name
        type(By.cssSelector("#FirstName"), "Sebastian");
        //enter last name
        type(By.cssSelector("#LastName"), "Smith");
        //enter email
        type(By.cssSelector("#Email"), "sebas" + i + "@yh.com");
        //enter password
        type(By.cssSelector("#Password"), "12345Qw$");
        //enter confirm password
        type(By.cssSelector("#ConfirmPassword"), "12345Qw$");
        //click on Register button
        click(By.cssSelector("#register-button"));
        //assert Log Out button is present
        softAssert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
        //assert successful registration message is present
        softAssert.assertTrue(isElementPresent(By.cssSelector(".result")));
        //assert account link is present
        //softAssert.assertTrue(isElementPresent(By.xpath("//a[.='sebas" + i +"@yh.com']")));
        softAssert.assertAll();
    }
}
