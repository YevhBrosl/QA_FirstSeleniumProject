package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HoverPage extends BasePage {
    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.figure img")
    List<WebElement> avatars;

    public HoverPage hoverOverAvatar(int index) {
        if (index >= 0 && index < avatars.size()) {
            WebElement avatar = avatars.get(index);
            Actions actions = new Actions(driver);
            actions.moveToElement(avatar).perform();
        } else {
            System.out.println("Index: " + index + " is out of bounds for avatars list size: " + avatars.size());
        }
        return this;
    }

    @FindBy(css = ".figcaption>h5")
    WebElement caption;

    public HoverPage verifyName(String name) {
        Assert.assertTrue(caption.getText().contains(name));
        return this;
    }

    @FindBy(css = ".figcaption>a")
    WebElement viewProfileLink;

    public HoverPage viewProfile() {
        click(viewProfileLink);
        return this;
    }

    @FindBy(css = "h1")
    WebElement profile;

    public HoverPage verifyProfile(String text) {
        Assert.assertEquals(profile.getText(), text);
        return this;
    }
}
