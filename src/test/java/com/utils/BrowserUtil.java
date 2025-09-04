package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserUtil(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class);
    }

    public void clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void clickOn(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
    }

    public void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }


}
