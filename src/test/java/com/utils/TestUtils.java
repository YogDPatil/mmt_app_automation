package com.utils;

import com.constant.ConfigConst;

import java.io.FileInputStream;
import java.util.Properties;

public class TestUtils {


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
}
