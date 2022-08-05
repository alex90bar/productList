package com.example.alex90bar.productlist.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductToListRq
 *
 * @author alex90bar
 */

@ApiModel(description = "Модель запроса на добавление Product в List")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToListRq {

  @ApiModelProperty(value = "Название добавляемого Product", example = "Картофель молодой")
  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String productName;

  @ApiModelProperty(value = "Название добавляемого List", example = "Закуски")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String listName;

}


