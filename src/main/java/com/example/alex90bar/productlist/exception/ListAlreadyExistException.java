package com.example.alex90bar.productlist.exception;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ListAlreadyExistException
 *
 * @author alex90bar
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ListAlreadyExistException extends RuntimeException {

  public ListAlreadyExistException(String exMessage) { super(exMessage);
  }
}


