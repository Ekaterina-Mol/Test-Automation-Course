package org.it_academy.selenide.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.conditions.Visible;
import org.it_academy.selenide.framework.BasePage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String ONLINER_CATALOG_URL = "https://catalog.onliner.by/";
    private static final String CATALOG_CATEGORIES = "//*[@class= 'catalog-navigation-classifier__item ']" +
            "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    private static final String ACTIVE_CATALOG_CATEGORY = "//*[contains(@class,'catalog-navigation-classifier__item_active')]";
    private static final String CONTEXT_MENU_LINK = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-title']";
    private static final String PRODUCT_TEMPLATE = "//div[@class='catalog-navigation-list__category' and @data-id='%s']" +
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
            "//a";

    public CatalogPage navigateToOnlinerCatalogPage() {
        open(ONLINER_CATALOG_URL);
        return this;
    }

    public ElementsCollection getCatalogCategories() {
        return $$x(format(CATALOG_CATEGORIES))
                .should(CollectionCondition.sizeGreaterThan(0), ofSeconds(10));
    }

    public CatalogPage clickOnCatalogCategoryItem(String categoryName) {
        this.getCatalogCategories().findBy(text(categoryName)).click();
        return this;
    }

    public ElementsCollection getContextMenuLinks() {
        var contextMenuId = $x(ACTIVE_CATALOG_CATEGORY).getAttribute("data-id");
        return  $$x(format(CONTEXT_MENU_LINK, contextMenuId))
                .should(CollectionCondition.sizeGreaterThan(0), ofSeconds(10));
    }

    public CatalogPage clickOnContextMenuLink(String contextMenuLinkName) {
        this.getContextMenuLinks().findBy(text(contextMenuLinkName)).click();
        return this;
    }

    public ElementsCollection getProducts() {
        var contextMenuId = $x(ACTIVE_CATALOG_CATEGORY).getAttribute("data-id");
        return  $$x(format(PRODUCT_TEMPLATE, contextMenuId))
                .should(CollectionCondition.sizeGreaterThan(0), ofSeconds(10));
    }
}
