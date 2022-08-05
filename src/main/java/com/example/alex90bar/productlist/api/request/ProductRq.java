package com.example.alex90bar.productlist.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductRq
 *
 * @author alex90bar
 */

@ApiModel(description = "Модель запроса на создание Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRq {

  @ApiModelProperty(value = "Название", example = "Картофель молодой")
  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String name;

  @ApiModelProperty(value = "Описание продукта", example = "Урожай - лето 2022, Воронежская область. Нежный, рассыпчатый")
  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String description;

  @ApiModelProperty(value = "Количество килокалорий на 100г", example = "148")
  @NotNull
  @Min(value = 1)
  @Max(value = 50000)
  private Integer kcal;

}


