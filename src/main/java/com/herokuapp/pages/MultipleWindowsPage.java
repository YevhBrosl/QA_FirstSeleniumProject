package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage{
    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".example>a")
    WebElement tabButton;
    public MultipleWindowsPage openNewTab(int index) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(css = "h3")
    WebElement tabTitle;
    public MultipleWindowsPage verifyNewTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(tabTitle, text,5));
        return this;
    }
}
