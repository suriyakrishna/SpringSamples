package com.kishan.springpractice.controllers;

import com.kishan.springpractice.models.mongo.ProductResponse;
import com.kishan.springpractice.services.mongo.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello From Product Controller";
    }

    @GetMapping("/name/{name}")
    public Collection<ProductResponse> getProductById(@PathVariable(name = "name", required = true) String name) {
        Collection<ProductResponse> p = productService.getProductByName(name);
        return p;
    }
}
