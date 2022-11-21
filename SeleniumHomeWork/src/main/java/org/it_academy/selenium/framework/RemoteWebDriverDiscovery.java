package org.it_academy.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteWebDriverDiscovery {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static void setDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://127.0.0.1:4444/"),
                    capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            System.out.println("Remote driver connection failed");
            e.printStackTrace();
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
