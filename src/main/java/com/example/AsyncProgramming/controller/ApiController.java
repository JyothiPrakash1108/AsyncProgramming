package com.example.AsyncProgramming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AsyncProgramming.dto.ApiResult;
import com.example.AsyncProgramming.service.ApiService;

import reactor.core.publisher.Mono;

@RestController
public class ApiController {
    
    @Autowired
    private ApiService apiService;


    @GetMapping("/products")
    public ApiResult getProductsSync(){
        ApiResult result = apiService.getProductsSync();
        return result;
    }

   @GetMapping("/products/async")
    public Mono<ApiResult> getProductsAsync(){
        System.out.println("Thread handelling the req " + Thread.currentThread().getName());
        Mono<ApiResult> result = apiService.getProductsAsync();
        return result;
    }
}
