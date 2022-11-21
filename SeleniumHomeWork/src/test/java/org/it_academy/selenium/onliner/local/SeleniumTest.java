package org.it_academy.selenium.onliner.local;

import org.it_academy.selenium.framework.WebDriverDiscovery;
import org.it_academy.selenium.pageobject.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    private HomePage homePage;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void startUp(String browser) {
        WebDriverDiscovery.setDriver(browser);

        this.homePage = new HomePage(WebDriverDiscovery.getDriver());
        this.homePage.navigateToHomePage();
    }

    @AfterMethod
    public void completing() {
        this.homePage.closeBrowser();
    }
    @Test
    public void checkForRequiredSections() {
        List<String> expectedCategories = Arrays.asList(
                "Электроника",
                "Компьютеры и сети",
                "Бытовая техника",
                "Стройка и ремонт",
                "Дом и сад",
                "Авто и мото",
                "Красота и спорт",
                "Детям и мамам",
                "Работа и офис");

        var categories = this.homePage.getCategoryWebElements()
                .stream()
                .map(category -> category.getText())
                .collect(toList());;

        assertThat(categories).containsAll(expectedCategories);
    }
    @Test
    public void checkContextMenuForComputersLink() {
        List<String> expectedMenuItems= Arrays.asList(
                "Ноутбуки, компьютеры, мониторы",
                "Комплектующие",
                "Хранение данных",
                "Сетевое оборудование");

        var menuItems = this.homePage
                .clickOnCategory("Компьютеры и сети")
                .getContextMenuItemsForActiveCategory()
                .stream()
                .map(item -> item.getText())
                .collect(toList());

        assertThat(menuItems).containsAll(expectedMenuItems);
    }
    @Test
    public void checkListOfProductsInAccessoriesCategory() {
        var products = this.homePage
                .clickOnCategory("Компьютеры и сети")
                .clickOnContextMenuLink("Комплектующие")
                .getProducts();
        var titles = products
                .stream()
                .map(product -> product.findElement(By.className("catalog-navigation-list__dropdown-title")))
                .collect(toList());
        var descriptions = products
                .stream()
                .map(product -> product.findElement(By.className("catalog-navigation-list__dropdown-description")))
                .collect(toList());

        assertThat(titles).noneMatch(title -> title.getText().isEmpty());
        assertThat(descriptions).noneMatch(description -> description.getText().isEmpty());
        assertThat(descriptions).allMatch(description -> description.getText().contains("\n"));
    }
}


