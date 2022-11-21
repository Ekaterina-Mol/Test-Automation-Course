package org.it_academy.selenium.rest_api.endpoint;

import org.it_academy.selenium.framework.PropertiesReader;

public class SushiVeslaEndpoints {
    public static String getCatalogSearchSushiVeslaEndPoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla");
    }

    public static String addFilterByTyp(String url, String filterValue) {
        if (url.contains("?")) {
            url = url + '&';
        } else {
            url = url + '?';
        }

        return String.format(url + PropertiesReader.getEndpointProperty("catalog.search.sushivesla.filter.sushityp"), filterValue);
    }
}
