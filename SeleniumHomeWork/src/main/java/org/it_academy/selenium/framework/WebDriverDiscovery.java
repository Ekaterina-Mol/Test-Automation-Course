package org.it_academy.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverDiscovery {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverDiscovery.class);

    private static ThreadLocal<RemoteWebDriver> remoteWebDriver =
            new ThreadLocal();

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String name) {
        try {


        switch (name) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver.set(new OperaDriver());
                break;
            default:
                new IllegalArgumentException("Driver type not found");
        }

        logger.info("Driver created for " + name + " browser");
        }
        catch (IllegalArgumentException e) {
            logger.error("Specified driver was not found in the system - " + name + ". Stack trace: \n" + e.getStackTrace().toString());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }
}
