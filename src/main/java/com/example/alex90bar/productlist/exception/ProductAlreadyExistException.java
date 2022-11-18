package com.example.alex90bar.productlist.exception;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ProductAlreadyExistException
 *
 * @author alex90bar
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistException extends RuntimeException {

  public ProductAlreadyExistException(String exMessage) { super(exMessage);
  }
}


