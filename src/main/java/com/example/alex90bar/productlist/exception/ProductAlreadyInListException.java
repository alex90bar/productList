package com.example.alex90bar.productlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ProductAlreadyInListException
 *
 * @author alex90bar
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductAlreadyInListException extends RuntimeException {

  public ProductAlreadyInListException(String exMessage) { super(exMessage);
  }
}


