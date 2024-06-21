package com.demoshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameLinkPresent(String itemName) {
        return isTextPresent(By.cssSelector(".cart-item-row .product>a"), itemName);
    }

    public void clickOnShoppingCartLink() {
        click(By.id("topcartlink"));
    }
    //[href='/cart'].ico-cart .cart-label

    public void clickOnAddToCartButton() {
        click(By.cssSelector(".item-box:nth-child(3) .buttons>input"));
    }

    public void removeItemFromCart() {
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }
}
