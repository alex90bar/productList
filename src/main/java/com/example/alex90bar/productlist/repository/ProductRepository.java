package com.example.alex90bar.productlist.repository;

import com.example.alex90bar.productlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 *
 * @author alex90bar
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
