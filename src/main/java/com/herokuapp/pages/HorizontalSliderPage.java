package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage{
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sliderContainer>input")
    WebElement sliderContainer;

    public HorizontalSliderPage moveSlider() {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderContainer,55, 0).perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;
    public HorizontalSliderPage verifySliderValue(String value) {
        Assert.assertEquals(range.getText(), value);
        return this;
    }
}
