package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class ExitIntentPage extends BasePage{
    public ExitIntentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[.='Close']")
    WebElement close;

    public ExitIntentPage exitViewport() {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Dimension dimension = driver.manage().window().getSize();

        int x = dimension.getWidth()/2;
        int y = dimension.getHeight()/2 - 500;
        robot.mouseMove(x, y);
        pause(1000);

        click(close);

        return this;
    }



    public ExitIntentPage verifyCloseButtonIsNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[.='Close']")));
        Assert.assertTrue(isElementInvisible);
//        String url = js.executeScript("return document.URL;").toString();
//        System.out.println(url);
//        Assert.assertEquals(url, pageUrl);
        return this;
    }

//    public ExitIntentPage verifyReturnToExitIntentPage(String pageUrl) {
//        try {
//            String url = (String) js.executeScript("return document.URL;");
//            System.out.println("Current URL: " + url);
//            Assert.assertEquals(url, pageUrl, "The current URL does not match the expected URL.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail("Failed to retrieve the current URL.");
//        }
//        return this;
//    }

}
