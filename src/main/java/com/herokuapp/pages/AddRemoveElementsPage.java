package com.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddRemoveElementsPage extends BasePage{
    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

//    public AddRemoveElementsPage addRemoveElementWithKeyboardEvent() {
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.TAB).perform();
//        actions.sendKeys(Keys.TAB).perform();
//        pause(2000);
//        actions.sendKeys(Keys.ENTER).perform();
//        pause(2000);
//        actions.sendKeys(Keys.TAB).perform();
//        pause(2000);
//        actions.sendKeys(Keys.ENTER).perform();
//        pause(2000);
//        return this;
//    }
//
//    public AddRemoveElementsPage verifyElementIsDeleted() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".added-manually")));
//        Assert.assertTrue(isElementInvisible);
//        return this;
//    }

    public AddRemoveElementsPage addElements() {
        new Actions(driver).sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = ".added-manually")
    WebElement deleteButton;

    public AddRemoveElementsPage verifyAddElements() {
        Assert.assertTrue(isElementVisible(deleteButton));
        return this;
    }

    public AddRemoveElementsPage removeElements() {
        addElements();
        pause(1000);
        new Actions(driver).sendKeys(Keys.TAB,Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = ".added-manually")
    List<WebElement> deleteButton1;

    public AddRemoveElementsPage verifyRemoveElements() {
        // Assert.assertTrue(isElementPresent(deleteButton1));
        Assert.assertTrue(deleteButton1.isEmpty());
        return this;
    }
}
