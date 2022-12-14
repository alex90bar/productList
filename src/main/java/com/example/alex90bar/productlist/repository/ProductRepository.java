package com.example.alex90bar.productlist.repository;

import com.example.alex90bar.productlist.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 *
 * @author alex90bar
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByName(String name);

  List<Product> findAllByListId(Long listId);

  Boolean existsByName(String name);

}
