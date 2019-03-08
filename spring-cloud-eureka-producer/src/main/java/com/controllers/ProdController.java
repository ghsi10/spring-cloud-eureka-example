package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {

    @GetMapping("/{name}")
    public String helloWithName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/")
    public String helloWithoutName() {
        return "Hello guest";
    }

}
