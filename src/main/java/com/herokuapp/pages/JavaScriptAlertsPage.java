package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage{
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    WebElement jsAlertButton;
    public JavaScriptAlertsPage jsAlert() {
        click(jsAlertButton);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "result")
    WebElement jsAlertResult;
    public JavaScriptAlertsPage verifyResult(String result) {
        Assert.assertTrue(shouldHaveText(jsAlertResult, result, 5));
        return this;
    }

    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement jsConfirmButton;
    public JavaScriptAlertsPage selectResult(String text) {
        click(jsConfirmButton);

        if (text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;
    public JavaScriptAlertsPage verifyConfirmResult(String result) {
        Assert.assertTrue(shouldHaveText(confirmResult, result, 5));
        return this;
    }

    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement jsPromptButton;
    public JavaScriptAlertsPage sendPrompt(String prompt) {
        click(jsPromptButton);

        if (prompt != null) {
            driver.switchTo().alert().sendKeys(prompt);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement promptResult;
    public JavaScriptAlertsPage verifyPrompt(String prompt) {
        Assert.assertTrue(shouldHaveText(promptResult, prompt,5));
        return this;
    }
}
