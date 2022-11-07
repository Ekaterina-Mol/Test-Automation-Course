package org.it_academy.selenide;

import com.codeborne.selenide.CollectionCondition;
import org.it_academy.selenide.pageobject.CatalogPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class CatalogPageTest {

    @Test
    public void checkCatalogCategories() {
        var expectedCategories = new ArrayList<String>() {
            {
                add("Электроника");
                add("Компьютеры и сети");
                add("Бытовая техника");
                add("Стройка и ремонт");
                add("Дом и сад");
                add("Авто и мото");
                add("Красота и спорт");
                add("Детям и мамам");
                add("Работа и офис");
            }
        };

        new CatalogPage().navigateToOnlinerCatalogPage().getCatalogCategories().should(CollectionCondition.containExactTextsCaseSensitive(expectedCategories));
    }

    @Test
    public void checkContextMenuForComputersLink() {
        var expectedLinks = new ArrayList<String>() {
            {
                add("Ноутбуки, компьютеры, мониторы");
                add("Комплектующие");
                add("Хранение данных");
                add("Сетевое оборудование");
            }
        };

        new CatalogPage()
                .navigateToOnlinerCatalogPage()
                .clickOnCatalogCategoryItem("Компьютеры и сети")
                .getContextMenuLinks()
                .should(CollectionCondition.containExactTextsCaseSensitive(expectedLinks));
    }

    @Test
    public void checkListOfProductsInAccessoriesCategory() {
        new CatalogPage()
                .navigateToOnlinerCatalogPage()
                .clickOnCatalogCategoryItem("Компьютеры и сети")
                .clickOnContextMenuLink("Комплектующие")
                .getProducts()
                .should(CollectionCondition.noneMatch("One or more of the products don't have the title", product -> product.findElement(By.className("catalog-navigation-list__dropdown-title")).getText().isEmpty()), Duration.ofSeconds(10))
                .should(CollectionCondition.noneMatch("One or more of the products don't have the description", product -> product.findElement(By.className("catalog-navigation-list__dropdown-description")).getText().isEmpty()), Duration.ofSeconds(10))
                .should(CollectionCondition.allMatch("One or more of the products don't have count or minimal cost", product -> product.findElement(By.className("catalog-navigation-list__dropdown-description")).getText().contains("\n")), Duration.ofSeconds(10));
    }
}
