package com.produit.produitservice.repository;

import com.produit.produitservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// le repository qui met en liaision notre model avec la Db

public interface ProductRepository extends JpaRepository<Product, Long> {
}
