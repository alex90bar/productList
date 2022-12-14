package com.example.alex90bar.productlist.model;

import io.swagger.annotations.ApiModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Product
 *
 * @author alex90bar
 */

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "kcal", nullable = false)
  private Integer kcal;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "list_id", referencedColumnName = "id")
  private List list;

}


