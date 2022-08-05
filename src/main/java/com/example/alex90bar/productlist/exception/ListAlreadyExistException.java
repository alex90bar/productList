package com.example.alex90bar.productlist.exception;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * ListAlreadyExistException
 *
 * @author alex90bar
 */

public class ListAlreadyExistException extends RuntimeException {

  public ListAlreadyExistException(String exMessage) { super(exMessage);
  }
}


