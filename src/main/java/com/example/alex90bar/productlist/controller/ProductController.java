package com.example.alex90bar.productlist.controller;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 *
 * @author alex90bar
 */

@Api(description = "Работа с Product, создание, получение и добавление в List")
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  @ApiOperation("Создание нового Product в БД, проверяет на наличие по названию")
  @PostMapping
  public ResponseEntity<String> create(@Valid @RequestBody ProductRq productRq){
    productService.create(productRq);
    return new ResponseEntity<>("Product added succesfully", HttpStatus.OK);
  }

  @ApiOperation("Помещает выбранный Product в существующий List, проверяет на наличие по названию, "
      + "проверяет на наличие в List")
  @PutMapping
  public ResponseEntity<String> putProductToList(@Valid @RequestBody ProductToListRq productToListRq){
    productService.putProductToList(productToListRq);
    return new ResponseEntity<>(productToListRq.getProductName()
        + " product added succesfully to list " + productToListRq.getListName(), HttpStatus.OK);
  }

  @ApiOperation("Получение всех существующих Product")
  @GetMapping
  public List<ProductRs> getAllProducts(){
    return productService.getAllProducts();
  }



}


