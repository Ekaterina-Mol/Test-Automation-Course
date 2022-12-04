package org.it_academy.selenium.pageobject;

import org.it_academy.selenium.framework.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        Dimension dimension = new Dimension(1920, 1080);
        this.driver.manage().window().setSize(dimension);
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(elementToBeClickable(by));
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(visibilityOfAllElementsLocatedBy(by));
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
