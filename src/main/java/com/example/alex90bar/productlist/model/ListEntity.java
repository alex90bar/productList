package com.example.alex90bar.productlist.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * ListEntity
 *
 * @author alex90bar
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("list")
public class ListEntity {

  @Id
  private String id;

  @Field(name = "name")
  @Indexed(unique = true)
  private String name;


}


