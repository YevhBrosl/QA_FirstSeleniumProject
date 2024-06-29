package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage swapShapesWithDragAndDrop() {
        new Actions(driver).dragAndDrop(columnA, columnB).perform();
        return this;
    }

    public DragAndDropPage swapShapesWithDragAndDropBy() {

        int xOffset = columnA.getLocation().getX();
        int yOffset = columnA.getLocation().getY();

        int xOffset1 = columnB.getLocation().getX();
        int yOffset1 = columnB.getLocation().getY();

        xOffset = xOffset1 - xOffset;
        yOffset = yOffset1 - yOffset;

        new Actions(driver).dragAndDropBy(columnA, xOffset, yOffset).perform();
        return this;
    }

    public DragAndDropPage verifySwap(String columnTitle) {
        Assert.assertEquals(columnA.getText(), columnTitle);
        return this;
    }
}
