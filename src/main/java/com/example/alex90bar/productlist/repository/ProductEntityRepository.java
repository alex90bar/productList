package com.example.alex90bar.productlist.repository;

import com.example.alex90bar.productlist.model.ProductEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ProductEntityRepository
 *
 * @author alex90bar
 */

public interface ProductEntityRepository extends MongoRepository<ProductEntity, String> {


  Optional<ProductEntity> findByName(String name);

  List<ProductEntity> findAllByListId(String listId);

  Boolean existsByName(String name);

}
