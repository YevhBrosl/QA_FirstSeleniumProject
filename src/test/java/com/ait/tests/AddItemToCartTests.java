package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
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
        softAssert.assertTrue(isElementPresent(By.xpath("//a[.='seba@yh.com']")));
        softAssert.assertAll();
    }

    @Test
    public void addToCartPositiveTest() {
        //click on Add to cart link
        click(By.xpath("//input[contains(@onclick,'31')]"));
        //click on shopping cart link
        click(By.xpath("//span[.='Shopping cart']"));
        //assert product name link is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='product-name']")));
    }

    @AfterMethod
    public void postCondition() {
        //click on the remove checkbox
        click(By.name("removefromcart"));
        //click on the update cart button
        click(By.name("updatecart"));
    }
}
