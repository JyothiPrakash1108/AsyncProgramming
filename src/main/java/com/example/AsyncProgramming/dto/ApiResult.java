package com.example.AsyncProgramming.dto;

import java.util.List;

public class ApiResult {
    List<ApiMeasurment> products;

    public ApiResult(List<ApiMeasurment> products) {
        this.products = products;
    }

    public ApiResult() {
    }

    public List<ApiMeasurment> getProducts() {
        return products;
    }

    public void setProducts(List<ApiMeasurment> products) {
        this.products = products;
    }

}
