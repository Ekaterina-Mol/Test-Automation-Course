package org.it_academy.bddhomework.pageobject;

import org.it_academy.bddhomework.framework.BasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    private static final String ONLINER_URL = "https://onliner.by/";
    private static final String MENU_ITEM_TEMPLATE = "//a[contains(@class, 'b-main-navigation__link')]//*[contains(text(), '%s')]";
    private static final String CONTEXT_MENU = "//li[contains(@class,'b-main-navigation__item_active')]//div[contains(@class,'b-main-navigation__dropdown_visible')]";
      public HomePage navigateToHomePage() {
        open(ONLINER_URL);
        return this;
    }

    public HomePage hoverMenuItem(String menuItem){
        $x(format(MENU_ITEM_TEMPLATE, menuItem)).hover();
        return this;
    }

    public boolean isContextMenuDisplayed() {
        return $x(format(CONTEXT_MENU)).shouldBe(visible, ofSeconds(15)).isDisplayed();
    }
}
