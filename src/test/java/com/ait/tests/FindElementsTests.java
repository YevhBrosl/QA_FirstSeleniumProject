package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        // maximize browser to window fit
        driver.manage().window().maximize();
        //wait for all elements on the page to load before testing starts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTagName() {
        //find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocator() {
        //by id
        driver.findElement(By.id("city"));

        //by class name
        WebElement phone = driver.findElement(By.className("telephone"));
        System.out.println(phone.getText());

        //link text - old strategy (not recommended)
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        //partial link text - old strategy (not recommended)
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tag name -> tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> #id
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //class name -> .class
        //driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".telephone"));

        //[attr='value']
        WebElement sccSelector = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(sccSelector.getAttribute("type"));

        //contains -> *
        WebElement elementContains = driver.findElement(By.cssSelector("[ng-reflect-router-link*='car']"));
        System.out.println(elementContains.getText());

        //starts with -> ^
        driver.findElement(By.cssSelector("[ng-reflect-router-link^='let']"));

        //ends with -> $
        driver.findElement(By.cssSelector("[ng-reflect-router-link$='work']"));
    }

    @Test
    public void findElementByXpath() {
        // //tag[@attr='value']
        // //*[@attr='value']

        //tag name -> //tag
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> //*[@id='value']
        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //class name -> //*[@class='value']
        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //text = //tag[text()='Text']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

        //contains -> //tag[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla!')]"));

        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//input[contains(@class,'target')]"));

        //starts with -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//input[starts-with(@class,'ng-untouched')]"));
    }

    //css=div>span --> xpath=//div/span

    //css=div span --> xpath=//div//span

    //xpath=//input/.. -> one level up

    //ancestor -> parent -> child -> descendant

    @Test
    public void findElementByXpath2() {
        //parent
        driver.findElement(By.xpath("//h1/parent::*"));//1 level up
        driver.findElement(By.xpath("//h1/.."));//1 level up
        driver.findElement(By.xpath("//h1/parent::div"));//1 level up

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));// all matches
        driver.findElement(By.xpath("//h1/ancestor::div"));// 2 matches
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));// 1 match

        //following sibling
        driver.findElement(By.xpath("//h1/following-sibling::*"));// all matches
        driver.findElement(By.xpath("//h1/following-sibling::form"));//1 match

        //preceding sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));//1 match
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
