package com.example.alex90bar.productlist.api.request;

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

  private String name;
  private String description;
  private Integer kcal;

}


