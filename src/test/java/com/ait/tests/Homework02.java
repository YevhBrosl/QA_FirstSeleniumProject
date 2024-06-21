package com.ait.tests;

import com.demoshop.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework02{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
    }
    @Test
    public void findElementByCssSelector() {
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector(".header-logo"));
        driver.findElement(By.cssSelector("[alt='Tricentis Demo Web Shop']"));

        WebElement registerLink = driver.findElement(By.cssSelector(".ico-register"));
        System.out.println(registerLink.getText());

        driver.findElement(By.cssSelector("li#topcartlink"));

        WebElement cartLink = driver.findElement(By.cssSelector("[href='/cart']"));
        System.out.println(cartLink.getAttribute("class"));

        WebElement slider = driver.findElement(By.cssSelector("#nivo-slider"));
        System.out.println(slider.getCssValue("width"));

        WebElement subscribeButton = driver.findElement(By.cssSelector("#newsletter-subscribe-button"));
        System.out.println(subscribeButton.getAttribute("type"));
        System.out.println(subscribeButton.getAttribute("value"));
        System.out.println(subscribeButton.getAttribute("class"));

        WebElement poll = driver.findElement(By.cssSelector(".poll-display-text"));
        System.out.println(poll.getText());

        WebElement picture = driver.findElement(By.cssSelector("[title='Show details for 14.1-inch Laptop']"));
        System.out.println(picture.getCssValue("background"));
    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//title"));
        driver.findElement(By.xpath("//div[@class='header-logo']"));
        driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
        driver.findElement(By.xpath("//a[@class='ico-register']"));
        driver.findElement(By.xpath("//li[@id='topcartlink']"));
        driver.findElement(By.xpath("//a[@href='/cart']"));
        driver.findElement(By.xpath("//div[@id='nivo-slider']"));
        driver.findElement(By.xpath("//input[contains(@id, 'newsletter')]"));
        driver.findElement(By.xpath("//strong[text()='Do you like nopCommerce?']"));
        driver.findElement(By.xpath("//strong[.='Do you like nopCommerce?']"));
        driver.findElement(By.xpath("//strong[contains(.,'nopCommerce?')]"));
        driver.findElement(By.xpath("//strong[starts-with(@class,'poll')]"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
