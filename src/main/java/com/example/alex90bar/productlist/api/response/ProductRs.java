package com.example.alex90bar.productlist.api.response;

import com.example.alex90bar.productlist.model.List;
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


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRs {

  private String name;
  private String description;
  private Integer kcal;
  private String list;

}


