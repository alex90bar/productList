package com.example.alex90bar.productlist.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

@ApiModel(description = "Модель запроса на создание Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRq {

  @ApiModelProperty(value = "Название", example = "Закуски")
  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String name;

}


