package com.ui.stepdefinations;

import com.constant.ConfigConst;
import com.ui.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @Before
    public void initDriver() throws Exception {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.setDriver("chrome");
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
