package com.example.alex90bar.productlist.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ListRq
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRq {

  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String name;

}


