package com.emarts.estore_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.emarts.estore_backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Many general methods are provided my JpaRepository, fetches data from database

    // JPQL (JPA Query Language)
    @Query("SELECT p FROM Product p WHERE " +
        "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + 
        "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + 
        "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + 
        "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProduct(String keyword);
}