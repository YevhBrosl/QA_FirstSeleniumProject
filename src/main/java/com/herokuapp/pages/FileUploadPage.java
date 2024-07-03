package com.herokuapp.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    public FileUploadPage uploadFileWithRobotKeyboard() {
        pause(1000);
        clickWithRectangle(fileUpload, 10, 3);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_4);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);

        pause(1000);
        click(fileSubmit);

        return this;
    }

    @FindBy(id = "uploaded-files")
    WebElement uploadedFile;

    public FileUploadPage verifyFileName(String name) {
        Assert.assertEquals(uploadedFile.getText(), name);
        return this;
    }

    public FileUploadPage uploadFileWithRobotMouse() {
        pause(1000);
        clickWithRectangle(fileUpload, 10, 3);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimensions x and y: " + dimension.getWidth() + " *** " + dimension.getHeight());

        int x = dimension.getWidth() / 3;
        int y = dimension.getHeight() / 2 - 70;
        robot.mouseMove(x, y);
        pause(1000);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);

        pause(1000);
        click(fileSubmit);

        return this;
    }

    @FindBy(id = "drag-drop-upload")
    WebElement dragDropUpload;

    public FileUploadPage uploadFileWithRobotMouseAndDragDrop() {
        pause(1000);
        click(dragDropUpload);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Dimension dimension = driver.manage().window().getSize();

        int x = dimension.getWidth() / 3;
        int y = dimension.getHeight() / 2 - 70;
        robot.mouseMove(x, y);
        pause(1000);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x, y+300);
        pause(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(xpath = "//span[.='A4.txt']")
    WebElement fileName;

    public FileUploadPage verifyFileName1(String name) {
        Assert.assertEquals(fileName.getText(), name);
        return this;
    }

    public FileUploadPage uploadFile(String path) {
        pause(1000);
        clickWithRectangle(fileUpload, 10, 3);
        fileUpload.sendKeys(path);
        pause(1000);
        click(fileSubmit);
        return this;
    }
}
