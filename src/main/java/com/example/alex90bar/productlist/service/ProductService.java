package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ProductMapper;
import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.exception.ListNotFoundException;
import com.example.alex90bar.productlist.exception.ProductNotFoundException;
import com.example.alex90bar.productlist.model.List;
import com.example.alex90bar.productlist.model.Product;
import com.example.alex90bar.productlist.repository.ListRepository;
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
  private final ListRepository listRepository;
  private final ProductMapper mapper;

  public void create(ProductRq productRq) {
    log.info("create begins " + productRq.toString());

    Product product = mapper.mapProductRqToProduct(productRq);
    productRepository.save(product);

    log.info("create ends");
  }

  public void putProductToList(ProductToListRq productToListRq) {
    log.info("putProductToList begins " + productToListRq.toString());

    //Проверяем существование List и Product
    List list = listRepository.findListByName(productToListRq.getListName())
        .orElseThrow(() -> new ListNotFoundException("List not found: " + productToListRq.getListName()));
    Product product = productRepository.findByName(productToListRq.getProductName())
        .orElseThrow(() -> new ProductNotFoundException("Product not found: " + productToListRq.getProductName()));

    //Добавляем Product в List
    product.setList(list);
    productRepository.save(product);

    log.info("putProductToList ends");
  }
}


