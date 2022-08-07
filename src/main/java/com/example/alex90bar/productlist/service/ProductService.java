package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ProductMapper;
import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.exception.ListNotFoundException;
import com.example.alex90bar.productlist.exception.ProductAlreadyExistException;
import com.example.alex90bar.productlist.exception.ProductAlreadyInListException;
import com.example.alex90bar.productlist.exception.ProductNotFoundException;
import com.example.alex90bar.productlist.model.ListEntity;
import com.example.alex90bar.productlist.model.ProductEntity;
import com.example.alex90bar.productlist.repository.ListEntityRepository;
import com.example.alex90bar.productlist.repository.ProductEntityRepository;
import java.util.stream.Collectors;
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

  private final ProductEntityRepository productEntityRepository;
  private final ListEntityRepository listEntityRepository;
  private final ProductMapper mapper;

  public void create(ProductRq productRq) {
    log.info("create begins " + productRq.toString());

    //Проверяем, есть ли Product с таким именем в базе, если нет - создаем.
    if (productEntityRepository.existsByName(productRq.getName())){
      throw new ProductAlreadyExistException("Product with name: " + productRq.getName()
          + " = already exists. Please, correct the name");
    }

    ProductEntity productEntity = mapper.mapProductRqToProductEntity(productRq);
    productEntityRepository.save(productEntity);

    log.info("create ends");
  }

  public void putProductToList(ProductToListRq productToListRq) {
    log.info("putProductToList begins " + productToListRq.toString());

    //Проверяем существование List и Product
    ListEntity listEntity = listEntityRepository.findListByName(productToListRq.getListName())
        .orElseThrow(() -> new ListNotFoundException("List not found: " + productToListRq.getListName()));
    ProductEntity productEntity = productEntityRepository.findByName(productToListRq.getProductName())
        .orElseThrow(() -> new ProductNotFoundException("Product not found: " + productToListRq.getProductName()));

    //Проверяем, возможно Product уже и так в данном List
    if (productEntity.getList() != null && productEntity.getList().getName().equals(productToListRq.getListName())){
      throw new ProductAlreadyInListException("Product " + productToListRq.getProductName()
          + " already is in list " + productToListRq.getListName());
    }

    //Добавляем Product в List
    productEntity.setList(listEntity);
    productEntityRepository.save(productEntity);

    log.info("putProductToList ends");
  }

  public java.util.List<ProductRs> getAllProducts() {
    log.info("getAllProducts begins");
    java.util.List<ProductEntity> productList = productEntityRepository.findAll();

    log.info("getAllProducts ends");
    return productList.stream().map(mapper::mapProductEntityToProductRs).collect(Collectors.toList());
  }
}


