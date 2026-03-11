package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private Properties properties;
    
    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }
    
    public String getExecution() {
        return properties.getProperty("execution");
    }
    
    public String getBrowser() {
        return properties.getProperty("browser");
    }
    
    public String getGridUrl() {
        return properties.getProperty("grid.url");
    }
    
    public String getBaseURL() {
        return properties.getProperty("base.url");
    }
}
