package com.example.AsyncProgramming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.AsyncProgramming.dto.ApiResult;

import reactor.core.publisher.Mono;

@Service
public class ApiService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;
    public ApiResult getProductsSync(){
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForObject("https://dummyjson.com/products", ApiResult.class);
    }
    public Mono<ApiResult> getProductsAsync(){
        Mono<ApiResult> result = 
                                webClient.get().uri("https://dummyjson.com/products")
                                .retrieve().bodyToMono(ApiResult.class)
                                .doOnSuccess(ApiResult -> 
                                    System.out.println("Thread handelling async request"+Thread.currentThread().getName())
                                )
                                .doOnSubscribe(s -> System.out.println("Subscribed on " + Thread.currentThread().getName()))
                                .doOnRequest(r -> System.out.println("Request received " + Thread.currentThread().getName()))
                                .doOnNext(v -> System.out.println("OnNext " + Thread.currentThread().getName()));

        return result;
    }
}
