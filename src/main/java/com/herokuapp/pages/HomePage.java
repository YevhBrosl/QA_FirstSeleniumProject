package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#content>ul>li:nth-child(29)>a")
    WebElement javaScriptAlerts;
    public HomePage getJavaScriptAlerts() {
        click(javaScriptAlerts);
        return this;
    }
}
