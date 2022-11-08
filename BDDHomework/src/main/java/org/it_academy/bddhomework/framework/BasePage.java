package org.it_academy.bddhomework.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public BasePage() {
        Configuration.browser = SelenideWebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 200000;
        open();
    }
}
