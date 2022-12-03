package org.it_academy.selenium.framework;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String browser) {
        switch (browser){
            case "firefox":
                capabilities = OptionsManager.getFirefoxDesiredCapabilities();
                break;
            default:
                capabilities = OptionsManager.getChromeDesiredCapabilities();
        }

        return capabilities;
    }
}
