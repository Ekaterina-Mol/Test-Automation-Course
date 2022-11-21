package org.it_academy.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String ONLINER_CATALOG_URL = "https://catalog.onliner.by/";

    private static final String CATALOG_CATEGORIES = "//*[@class= 'catalog-navigation-classifier__item ']" +
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    private static final String ACTIVE_CATALOG_CATEGORY = "//*[contains(@class,'catalog-navigation-classifier__item_active')]";
    private static final String CONTEXT_MENU_LINK = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-title']";
    private static final String PRODUCT_TEMPLATE = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
            "//a";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHomePage(){
        this.navigate(ONLINER_CATALOG_URL);
        return this;
    }

    public List<WebElement> getCategoryWebElements(){
        return this.waitForElementsVisible(By.xpath(CATALOG_CATEGORIES));
    }

    public HomePage clickOnCategory(String categoryName) {
        this.getCategoryWebElements().stream().filter(category -> category.getText().equals(categoryName)).findAny().get().click();

        return this;
    }

    public List<WebElement> getContextMenuItemsForActiveCategory() {
        return this. waitForElementsVisible(By.xpath(String.format(CONTEXT_MENU_LINK, this.getActiveDirectoryDataId())));
    }

    public HomePage clickOnContextMenuLink(String menuLink) {
        this.getContextMenuItemsForActiveCategory().stream().filter(menuItem -> menuItem.getText().equals(menuLink)).findAny().get().click();

        return this;
    }

    public List<WebElement> getProducts() {
        return this. waitForElementsVisible(By.xpath(String.format(PRODUCT_TEMPLATE, this.getActiveDirectoryDataId())));
    }

    private String getActiveDirectoryDataId() {
        return this.driver.findElement(By.xpath(ACTIVE_CATALOG_CATEGORY)).getAttribute("data-id");
    }

}
