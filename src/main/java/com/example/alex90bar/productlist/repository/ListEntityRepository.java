package com.example.alex90bar.productlist.repository;

import com.example.alex90bar.productlist.model.ListEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ListEntityRepository
 *
 * @author alex90bar
 */

public interface ListEntityRepository extends MongoRepository<ListEntity, String> {

  Optional<ListEntity> findListByName(String name);

  Boolean existsByName(String name);

}
