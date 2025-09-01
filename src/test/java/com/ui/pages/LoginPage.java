package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private static final By EMIAL_ICON_LOCATOR = By.xpath("//img[@data-cy='signInByMailButton']");
    private static final By EMAIL_FIELD_LOCATOR = By.xpath("//input[@placeholder='Enter Email Address']");
    private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//button[@data-cy='continueBtn']");
    private static final By PASSWORD_FIELD_LOCATOR = By.cssSelector("input#password");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@data-cy='login']");

    public void doLogin() {

    }
}
