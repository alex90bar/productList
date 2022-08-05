package com.example.alex90bar.productlist.api.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ListRs
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRs {

  private String name;
  private Integer totalKcal;
  private List<ProductRs> products;


}


