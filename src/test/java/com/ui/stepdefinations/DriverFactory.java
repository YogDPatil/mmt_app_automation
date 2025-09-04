package com.ui.stepdefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private DriverFactory instance;
    private static ThreadLocal<WebDriver> thrlcDriver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public DriverFactory getDriverInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static void setDriver(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                thrlcDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                thrlcDriver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                thrlcDriver.set(new EdgeDriver());
                break;
            default:
                throw new Exception("ERROR: " + browser + " is not supported.");
        }
    }

    public static WebDriver getDriver() {
        return thrlcDriver.get();
    }

    public static void quitDriver() {
        if (getDriver() == null) {
            getDriver().quit();
        }
    }
}
