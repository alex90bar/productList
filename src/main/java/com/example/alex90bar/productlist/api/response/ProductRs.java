package com.example.alex90bar.productlist.api.response;

import com.example.alex90bar.productlist.model.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductRs
 *
 * @author alex90bar
 */


@ApiModel(description = "Модель ответа сущности Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRs {

  @ApiModelProperty(value = "Название", example = "Картофель молодой")
  private String name;

  @ApiModelProperty(value = "Описание продукта", example = "Урожай - лето 2022, Воронежская область. Нежный, рассыпчатый")
  private String description;

  @ApiModelProperty(value = "Количество килокалорий на 100г", example = "148")
  private Integer kcal;

  @ApiModelProperty(value = "Название списка, в который входит продукт (если нет списка - "
      + "значение = Product isn't in any list)", example = "Закуски")
  private String list;

}


