package com.utils;

import com.constant.ConfigConst;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class TestUtil {


    public static String getValueFromPropertiesFile(ConfigConst key) {
        FileInputStream fis;
        Properties properties = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/qa_config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(String.valueOf(key));
    }

    public static String takeScreenshots(WebDriver driver) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = System.getProperty("user.dir") + "/screeshots";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            LocalTime localTime = LocalTime.now();
            String formatedDate = localTime.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss"));
            File destFile = new File(folderPath + "/screenshot-" + formatedDate + ".png");
            FileUtils.copyFile(srcFile, destFile);
            return folderPath + "/screenshot-" + formatedDate;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
