package org.it_academy.selenium.sushivesla;


import org.it_academy.selenium.rest_api.model.FilterTypes;
import org.it_academy.selenium.rest_api.model.ProductModel;
import org.it_academy.selenium.rest_api.service.ProductService;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SushiVeslaAPITest {
    @Test
    public void checkSearchProductItems() {
        List<ProductModel> models = new ProductService().getSearchProductItems();

        for (var model :
                models) {
            assertThat(model.getId()).isNotZero();
            assertThat(model.getKey()).isNotEmpty();
            assertThat(model.getFull_name()).isNotEmpty();
            assertThat(model.getName()).isNotEmpty();
        }
    }
    @Test
    public void checkSearchProductItemsWithFilterRolls() {
        var filters = new HashMap<FilterTypes, String>();
        filters.put(FilterTypes.Typ, "roll");

        List<ProductModel> models = new ProductService().getSearchProductItems(filters);

        for (var model :
                models) {
            assertThat(model.getName_prefix()).isEqualTo("Роллы");
        }
    }
}
