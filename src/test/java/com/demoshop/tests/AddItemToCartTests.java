package com.demoshop.tests;

import com.demoshop.data.ItemData;
import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

//    @BeforeMethod(enabled = false)
//    public void precondition() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillOutLoginForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.PASSWORD));
//        app.getUser().clickOnLoginButton();
//    }

    @Test
    public void addToCartPositiveTest() {
        app.getItem().clickOnAddToCartButton();
        app.getItem().clickOnShoppingCartLink();
        Assert.assertTrue(app.getItem().isProductNameLinkPresent(ItemData.ITEM_NAME));
    }

    @AfterMethod(enabled = true)
    public void postCondition() {
        app.getItem().removeItemFromCart();
    }
}
