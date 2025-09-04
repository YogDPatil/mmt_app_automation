package com.ui.pages;

import com.constant.ConfigConst;
import com.utils.BrowserUtil;
import com.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private BrowserUtil browser_util;

    private static final By EMAIL_ICON_LOCATOR = By.xpath("//img[@data-cy='signInByMailButton']");
    private static final By EMAIL_FIELD_LOCATOR = By.xpath("//input[@placeholder='Enter Email Address']");
    private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//button[@data-cy='continueBtn']");
    private static final By PASSWORD_FIELD_LOCATOR = By.cssSelector("input#password");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@data-cy='login']");

    public LoginPage(WebDriver driver) {
        browser_util = new BrowserUtil(driver);
    }

    public void doLogin(ConfigConst email, ConfigConst pass) {
        browser_util.clickOn(EMAIL_ICON_LOCATOR);
        browser_util.enterText(EMAIL_FIELD_LOCATOR, TestUtil.getValueFromPropertiesFile(email));
        browser_util.clickOn(CONTINUE_BUTTON_LOCATOR);
        browser_util.enterText(PASSWORD_FIELD_LOCATOR, TestUtil.getValueFromPropertiesFile(pass));
        browser_util.clickOn(LOGIN_BUTTON_LOCATOR);
    }
}
