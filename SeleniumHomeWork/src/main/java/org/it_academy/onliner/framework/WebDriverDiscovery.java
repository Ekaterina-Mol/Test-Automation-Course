package org.it_academy.onliner.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverDiscovery {

    private static ThreadLocal<RemoteWebDriver> remoteWebDriver =
            new ThreadLocal();

    public WebDriverDiscovery() {
        if (remoteWebDriver.get() == null) {
            startBrowser();
        }
    }

    private void startBrowser() {
        setWebDriver(new ChromeDriver());
    }

    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }
}
