package com.example.alex90bar.productlist.exception;

/**
 * ListNotFoundException
 *
 * @author alex90bar
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ListNotFoundException extends RuntimeException {

  public ListNotFoundException(String exMessage) { super(exMessage);
  }
}


