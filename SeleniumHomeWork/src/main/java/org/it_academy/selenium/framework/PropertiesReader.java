package org.it_academy.selenium.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_FILE = "/endpoints.properties";

    private static final String SELENIUM_GRID_FILE = "/seleniumGrid.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();
    private static final Properties SELENIUM_GRID_PROPERTIES = new Properties();

    static {
        initProperties(ENDPOINTS_PROPERTIES, ENDPOINTS_FILE);
        initProperties(SELENIUM_GRID_PROPERTIES, SELENIUM_GRID_FILE);
    }

    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(property);
    }

    public static String getSeleniumGridProperty(String property) { return SELENIUM_GRID_PROPERTIES.getProperty(property); }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to load properties from file: " + fileName);
        }
    }
}
