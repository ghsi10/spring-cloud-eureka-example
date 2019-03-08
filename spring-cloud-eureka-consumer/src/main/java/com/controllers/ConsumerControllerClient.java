package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ConsumerControllerClient {

    @Autowired
    @Qualifier("loadBalance")
    private WebClient.Builder webClient;

    @GetMapping("/")
    public String helloWithoutName() {
        return webClient.build().get().uri("http://producer").retrieve().bodyToMono(String.class).block();
    }

    @GetMapping("/{name}")
    public String helloWithName(@PathVariable String name) {
        return webClient.build().get().uri("http://producer/" + name).retrieve().bodyToMono(String.class).block();
    }
}