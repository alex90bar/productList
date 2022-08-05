package com.example.alex90bar.productlist.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ListRs
 *
 * @author alex90bar
 */

@ApiModel(description = "Модель ответа сущности List")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRs {

  @ApiModelProperty(value = "Название", example = "Закуски")
  private String name;

  @ApiModelProperty(value = "Сумма килокалорий на 100г всех продуктов из данного List", example = "1024")
  private Integer totalKcal;

  @ApiModelProperty(value = "Список продуктов, находящихся в данном List")
  private List<ProductRs> products;


}


