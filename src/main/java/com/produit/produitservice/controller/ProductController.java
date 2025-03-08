package com.produit.produitservice.controller;


import com.produit.produitservice.model.Product;
import com.produit.produitservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("/hello")

    //methode  sayHello
    public String sayHello() {
        return  "Hello World";
    }

    @GetMapping("/all")

    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

}
