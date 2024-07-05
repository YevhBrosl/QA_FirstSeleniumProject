package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "img")
    List<WebElement> images;

//    public BrokenImagesPage checkBrokenImages() {
//        System.out.println("Total number of images on the page: " + images.size());
//
//        for (int i = 0; i < images.size(); i++) {
//            WebElement image = images.get(i);
//            String imageURL = image.getAttribute("src");
//            verifyLinks(imageURL);
//
//            try {
//                boolean imageDisplay = (Boolean) ((JavascriptExecutor) driver)
//                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
//
//                if (imageDisplay) {
//                    System.out.println("DISPLAY - OK");
//                } else {
//                    System.out.println("DISPLAY - BROKEN");
//                    System.out.println("=================================================================================");
//                }
//            } catch (Exception e) {
//                System.out.println("ERROR occurred");
//            }
//        }
//        return this;
//    }

    public BrokenImagesPage defineLinksOfImages() {
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            verifyLinks(imageURL);
        }
        return this;
    }

    @FindBy(css = "img:nth-child(2)")
    WebElement image1;

    @FindBy(css = "img:nth-child(3)")
    WebElement image2;

    @FindBy(css = "img:nth-child(4)")
    WebElement image3;

    public BrokenImagesPage checkBrokenImages() {
        softAssert.assertTrue(checkImage(image1));
        softAssert.assertTrue(checkImage(image2));
        softAssert.assertTrue(checkImage(image3));
        softAssert.assertAll();
        return this;
    }
}
