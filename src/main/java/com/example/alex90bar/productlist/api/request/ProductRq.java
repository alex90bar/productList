package com.example.alex90bar.productlist.api.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductRq
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRq {

  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String name;

  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String description;

  @Min(value = 1)
  @Max(value = 50000)
  private Integer kcal;

}


