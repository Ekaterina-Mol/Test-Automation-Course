package org.it_academy.selenium.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"advertise","color_code","description","extended_name","forum","html_url","image_size","images","max_cobrand_cashback","max_installment_terms","micro_description","prices","prime_info","review_url","sale","second","status","stickers","url","reviews"})
public class ProductModel {
    private int id;
    private String key;
    private String name;
    private String full_name;
    private String name_prefix;

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }
}
