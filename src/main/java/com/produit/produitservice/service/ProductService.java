package com.produit.produitservice.service;


import com.produit.produitservice.model.Product;
import com.produit.produitservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.produit.produitservice.model.Product;


import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor


public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        Optional<Product> OptionalProduct = productRepository.findById(id);

        if (OptionalProduct.isEmpty()) {
          throw  new RuntimeException(" Déloser produit inexistente");
        }
        return OptionalProduct.get();
    }


    public String deleteProductById(long idProduct) {
        Optional<Product> OptionalProduct = productRepository.findById(idProduct);
        if (OptionalProduct.isEmpty()) {
            throw new RuntimeException("Desoler le produit inexistente, Suppression impossible");

        }
        productRepository.delete(OptionalProduct.get());
       return "Prduit supprimé avec succès !";
    }

    public Product editProduct(long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Produit n'inexistente, la modification impossible");
        }
       //stocker le produitAModifier
        Product productModify = optionalProduct.get();

        productModify.setName(product.getName());
        productModify.setPrice(product.getPrice());
        return productRepository.save(productModify);
    }
}
