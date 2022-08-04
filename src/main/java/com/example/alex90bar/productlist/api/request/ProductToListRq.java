package com.example.alex90bar.productlist.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductToListRq
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToListRq {

  private String productName;
  private String listName;

}


