package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class JQueryUIMenusPage extends BasePage{
    public JQueryUIMenusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Enabled']")
    WebElement enabled;

    @FindBy(xpath = "//a[.='Downloads']")
    WebElement downloads;

    @FindBy(xpath = "//a[.='PDF']")
    WebElement pdf;

    public JQueryUIMenusPage selectSubMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(enabled).perform();
        pause(1000);
        actions.moveToElement(downloads).perform();
        pause(1000);
        click(pdf);
        return this;
    }

//    public JQueryUIMenusPage verifyIsFileDownloaded(String downloadPath, String fileName) {
//        File dir = new File(downloadPath);
//        File[] dirContents = dir.listFiles();
//
//        if (dirContents != null) {
//            for (File file : dirContents)
//                if (file.getName().contains(fileName)) {
//                    file.delete();
//                }
//        }
//        return this;
//    }

    public JQueryUIMenusPage verifyIsFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        if (dirContents != null) {
            for (File file : dirContents) {
                if (file.getName().contains(fileName)) {
                    System.out.println("Attempting to delete file: " + file.getAbsolutePath());
                    if (file.exists()) {
                        boolean deleted = file.delete();
                        if (!deleted) {
                            System.err.println("Failed to delete file: " + file.getAbsolutePath());
                        } else {
                            System.out.println("File deleted: " + file.getAbsolutePath());
                        }
                    } else {
                        System.err.println("File does not exist: " + file.getAbsolutePath());
                    }
                }
            }
        }
        return this;
    }
}
