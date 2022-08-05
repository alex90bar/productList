package com.example.alex90bar.productlist.controller;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.service.ProductService;
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

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<String> create(@Valid @RequestBody ProductRq productRq){
    productService.create(productRq);
    return new ResponseEntity<>("Product added succesfully", HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<String> putProductToList(@Valid @RequestBody ProductToListRq productToListRq){
    productService.putProductToList(productToListRq);
    return new ResponseEntity<>(productToListRq.getProductName()
        + " product added succesfully to list " + productToListRq.getListName(), HttpStatus.OK);
  }

  @GetMapping
  public List<ProductRs> getAllProducts(){
    return productService.getAllProducts();
  }



}


