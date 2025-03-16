package com.produit.produitservice.controller;


import com.produit.produitservice.model.Product;
import com.produit.produitservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")


public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     *
     * @return endpoint pour recuperer tous les produit
     */
    @GetMapping("/all")

    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    /**
     *
     * @param product
     * @return endpoint pour creer un produit
     */

    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

    /**
     *
     * @param id
     * @return endpoint pour recuperer un product
     */

    @GetMapping("{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);

    }

    /**
     *
     * @param idProduct
     * @return endpoint pour supprimer un produit
     */

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable ("id") long idProduct){
       return  productService.deleteProductById(idProduct);
    }

    /**
     *
     * @param id
     * @param product
     * @return endpoint pour modifier un produit
     */

    @PutMapping("{id}")
    public Product editProduct(@PathVariable long id, @RequestBody Product product){

        return productService.editProduct(id,product);
    }




}
