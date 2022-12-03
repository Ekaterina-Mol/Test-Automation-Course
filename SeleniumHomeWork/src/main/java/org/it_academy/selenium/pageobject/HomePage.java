package org.it_academy.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String ONLINER_CATALOG_URL = "https://catalog.onliner.by/";

    private static final By CATALOG_CATEGORIES = By.xpath("//*[@class= 'catalog-navigation-classifier__item ']" +
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']");
    private static final By ACTIVE_CATALOG_CATEGORY = By.xpath("//*[contains(@class,'catalog-navigation-classifier__item_active')]");
    private static final String CONTEXT_MENU_LINK_PATTERN = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-title']";
    private static final String PRODUCT_PATTERN = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
            "//a";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHomePage(){
        navigate(ONLINER_CATALOG_URL);
        return this;
    }

    public List<WebElement> getCategoryWebElements(){
        return waitForElementsVisible(CATALOG_CATEGORIES);
    }

    public HomePage clickOnCategory(String categoryName) {
        getCategoryWebElements().stream().filter(category -> category.getText().equals(categoryName)).findAny().get().click();

        return this;
    }

    public List<WebElement> getContextMenuItemsForActiveCategory() {
        return waitForElementsVisible(By.xpath(String.format(CONTEXT_MENU_LINK_PATTERN, this.getActiveDirectoryDataId())));
    }

    public HomePage clickOnContextMenuLink(String menuLink) {
        getContextMenuItemsForActiveCategory().stream().filter(menuItem -> menuItem.getText().equals(menuLink)).findAny().get().click();

        return this;
    }

    public List<WebElement> getProducts() {
        return waitForElementsVisible(By.xpath(String.format(PRODUCT_PATTERN, this.getActiveDirectoryDataId())));
    }

    private String getActiveDirectoryDataId() {
        return driver.findElement(ACTIVE_CATALOG_CATEGORY).getAttribute("data-id");
    }

}
