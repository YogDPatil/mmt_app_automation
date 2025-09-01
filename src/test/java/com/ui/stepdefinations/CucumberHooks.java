package com.ui.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    protected WebDriver driver;

    @Before
    public void initDriver() throws Exception {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
