package com.example.alex90bar.productlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ProductNotFoundException
 *
 * @author alex90bar
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(String exMessage) { super(exMessage);
  }
}


