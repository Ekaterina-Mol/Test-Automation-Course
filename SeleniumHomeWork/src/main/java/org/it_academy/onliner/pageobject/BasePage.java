package org.it_academy.onliner.pageobject;

import org.it_academy.onliner.framework.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {
    private final WebDriver driver;
    private WebDriverDiscovery webDriverDiscovery;

    public BasePage() {
        webDriverDiscovery = new WebDriverDiscovery();
        driver = webDriverDiscovery.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(elementToBeClickable(by));
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
