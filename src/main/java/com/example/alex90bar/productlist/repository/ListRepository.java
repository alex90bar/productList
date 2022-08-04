package com.example.alex90bar.productlist.repository;

import com.example.alex90bar.productlist.model.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ListRepository
 *
 * @author alex90bar
 */

@Repository
public interface ListRepository extends JpaRepository<List, Long> {

  Optional<List> findListByName(String name);

}


