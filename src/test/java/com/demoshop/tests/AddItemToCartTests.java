package com.demoshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        //click on Login link
        click(By.cssSelector(".ico-login"));
        //enter email
        type(By.cssSelector("#Email"), "seba@yh.com");
        //enter password
        type(By.cssSelector("#Password"), "12345Qw$");
        //click on login button
        click(By.cssSelector(".login-button"));
    }

    @Test
    public void addToCartPositiveTest() {
        //click on Add to cart link
        click(By.cssSelector(".item-box:nth-child(3) .buttons"));
        //click on shopping cart link
        click(By.id("topcartlink"));
        //assert product name link is present
        Assert.assertTrue(isTextPresent(By.cssSelector(".cart-item-row .product>a"), "14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition() {
        //click on the remove checkbox
        click(By.name("removefromcart"));
        //click on the update cart button
        click(By.name("updatecart"));
    }
}
