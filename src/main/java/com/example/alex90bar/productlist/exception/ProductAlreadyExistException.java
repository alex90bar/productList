package com.example.alex90bar.productlist.exception;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * ProductAlreadyExistException
 *
 * @author alex90bar
 */

public class ProductAlreadyExistException extends RuntimeException {

  public ProductAlreadyExistException(String exMessage) { super(exMessage);
  }
}


