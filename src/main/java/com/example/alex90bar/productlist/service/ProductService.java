package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ProductMapper;
import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.model.Product;
import com.example.alex90bar.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ProductService
 *
 * @author alex90bar
 */

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper mapper;

  public void create(ProductRq productRq) {
    log.info("create begins " + productRq.toString());

    Product product = mapper.mapProductRqToProduct(productRq);
    productRepository.save(product);

    log.info("create ends");
  }
}


