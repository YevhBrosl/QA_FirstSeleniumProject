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

    @FindBy(css="#content>ul>li:nth-child(34)>a")
    WebElement nestedFrames;
    public HomePage getNestedFrames() {
        click(nestedFrames);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(33)>a")
    WebElement multipleWindows;
    public HomePage getMultipleWindows() {
        click(multipleWindows);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(24)>a")
    WebElement horizontalSlider;
    public HomePage getHorizontalSlider() {
        click(horizontalSlider);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(25)>a")
    WebElement hovers;
    public HomePage getHovers() {
        click(hovers);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(7)>a")
    WebElement contextMenu;
    public HomePage getContextMenu() {
        click(contextMenu);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(10)>a")
    WebElement dragAndDrop;

    public HomePage getDragAndDrop() {
        click(dragAndDrop);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(11)>a")
    WebElement dropdown;

    public HomePage getDropdown() {
        click(dropdown);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(18)>a")
    WebElement fileUpload;

    public HomePage getFileUpload() {
        click(fileUpload);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(28)>a")
    WebElement jQueryUIMenus;

    public HomePage getJQueryUIMenus() {
        click(jQueryUIMenus);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(16)>a")
    WebElement exitIntent;

    public HomePage getExitIntent() {
        click(exitIntent);
        return this;
    }

    @FindBy(css="#content>ul>li:nth-child(4)>a")
    WebElement brokenImages;

    public HomePage getBrokenImages() {
        click(brokenImages);
        return this;
    }
}
