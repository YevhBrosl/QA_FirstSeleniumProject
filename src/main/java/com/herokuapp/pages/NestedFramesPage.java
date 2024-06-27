package com.herokuapp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NestedFramesPage extends BasePage{
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "frame")
    List<WebElement> frames;
    public NestedFramesPage getListOfFrames() {
        System.out.println("Number of frames on the page: " + frames.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of frames on the page: " + numberOfFrames);
        return this;
    }

    public NestedFramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(css = "body")
    WebElement frame;
    public NestedFramesPage verifyFrameText(String text) {
        Assert.assertTrue(shouldHaveText(frame, text,5));
        return this;
    }

    @FindBy(css = "body")
    WebElement body;

    public NestedFramesPage switchToChildFrame(int index) {
        new NestedFramesPage(driver).switchToFrameByIndex(0);
        driver.switchTo().frame(index);
        return this;
    }

}
