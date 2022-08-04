package com.example.alex90bar.productlist.controller;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody ProductRq productRq){
    productService.create(productRq);
    return new ResponseEntity<>("Product added succesfully", HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<String> putProductToList(@RequestBody ProductToListRq productToListRq){
    productService.putProductToList(productToListRq);
    return new ResponseEntity<>(productToListRq.getProductName()
        + " product added succesfully to list " + productToListRq.getListName(), HttpStatus.OK);
  }



}


