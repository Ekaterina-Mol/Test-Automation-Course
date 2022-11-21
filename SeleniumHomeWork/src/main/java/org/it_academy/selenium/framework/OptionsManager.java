package org.it_academy.selenium.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsManager {
    //Get Chrome Options
    public static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return capabilities.merge(options);
    }

    //Get Firefox Options
    public static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        return capabilities;
    }
}
