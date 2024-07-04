package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddRemoveElementsPage extends BasePage{
    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public AddRemoveElementsPage addRemoveElementWithKeyboardEvent() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        pause(2000);
        actions.sendKeys(Keys.ENTER).perform();
        pause(2000);
        actions.sendKeys(Keys.TAB).perform();
        pause(2000);
        actions.sendKeys(Keys.ENTER).perform();
        pause(2000);
        return this;
    }

    public AddRemoveElementsPage verifyElementIsDeleted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".added-manually")));
        Assert.assertTrue(isElementInvisible);
        return this;
    }
}
