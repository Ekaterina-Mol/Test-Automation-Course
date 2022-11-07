package org.it_academy.selenide.framework;

public final class DriverCreatorFactory {

    private DriverCreatorFactory() {
    }

    public static WebDriverCreator getDriverCreator(String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriverCreator();
            case "firefox":
                return null;
            default:
                return new ChromeDriverCreator();
        }
    }
}
