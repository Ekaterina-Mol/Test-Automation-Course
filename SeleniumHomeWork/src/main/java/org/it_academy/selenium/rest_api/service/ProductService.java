package org.it_academy.selenium.rest_api.service;

import com.google.common.collect.ImmutableMap;
import io.restassured.response.ResponseBody;
import org.it_academy.selenium.rest_api.endpoint.SushiVeslaEndpoints;
import org.it_academy.selenium.rest_api.model.FilterTypes;
import org.it_academy.selenium.rest_api.model.ProductModel;
import org.it_academy.selenium.rest_api.utils.GetRequestUtils;
import org.it_academy.selenium.rest_api.utils.ResponseBodyUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private static final String PRODUCTS_JSON_PATH = "products";

    public List<ProductModel> getSearchProductItems() {
        return getSearchProductItems(new HashMap<FilterTypes, String>());
    }

    public List<ProductModel> getSearchProductItems(Map<FilterTypes, String> filters) {
        var endpoint = SushiVeslaEndpoints.getCatalogSearchSushiVeslaEndPoint();
        for (var filter:
             filters.entrySet()) {
            switch (filter.getKey()) {
                case Typ:
                    endpoint = SushiVeslaEndpoints.addFilterByTyp(endpoint, filter.getValue());
                }
            }

        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                endpoint,
                configureHeaders(), null);
        return ResponseBodyUtils.getObjectsByJsonPath(
                responseBody, PRODUCTS_JSON_PATH, ProductModel.class);
    }

    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }
}
