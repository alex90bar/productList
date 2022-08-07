package com.example.alex90bar.productlist.config;

import com.example.alex90bar.productlist.model.ListEntity;
import com.example.alex90bar.productlist.model.ProductEntity;
import com.example.alex90bar.productlist.repository.ListEntityRepository;
import com.example.alex90bar.productlist.repository.ProductEntityRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseChangeLog
 *
 * @author alex90bar
 */

@ChangeLog
public class DatabaseChangeLog {

  @ChangeSet(order = "001", id = "seedDatabase", author = "alex90bar", runAlways = true)
  public void seedDatabaseWithProducts(ProductEntityRepository productEntityRepository,
      ListEntityRepository listEntityRepository){

    //очищаем БД
    listEntityRepository.deleteAll();
    productEntityRepository.deleteAll();


    //заполняем БД тестовыми данными
    List<ListEntity> listEntities = new ArrayList<>();

    listEntities.add(createNewList("Cookies"));

    ListEntity fruits = createNewList("Fruits");
    ListEntity spirits = createNewList("Spirits");

    listEntities.add(fruits);
    listEntities.add(spirits);

    listEntityRepository.insert(listEntities);

    List<ProductEntity> productEntities = new ArrayList<>();

    productEntities.add(createNewProduct("Brownie", "Very sweety", 148));
    productEntities.add(createNewProduct("Cola", "Cola is coming", 348));
    productEntities.add(createNewProduct("Cola XXL", "Big Bottle", 678));
    productEntities.add(createNewProduct("Jack Daniels", "Classic one", 76, spirits));
    productEntities.add(createNewProduct("Champagne", "France is coming", 185, spirits));
    productEntities.add(createNewProduct("Banana", "1 kilo", 795, fruits));
    productEntities.add(createNewProduct("Apple", "from Georgia", 43, fruits));
    productEntities.add(createNewProduct("Pineapple", "Pineapple pie", 11, fruits));

    productEntityRepository.insert(productEntities);
  }

  private ListEntity createNewList(String name){
    ListEntity listEntity = new ListEntity();
    listEntity.setName(name);
    return listEntity;
  }

  private ProductEntity createNewProduct(String name, String description, Integer kcal) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setName(name);
    productEntity.setDescription(description);
    productEntity.setKcal(kcal);
    return productEntity;
  }

  private ProductEntity createNewProduct(String name, String description,
      Integer kcal, ListEntity listEntity){
    ProductEntity productEntity = createNewProduct(name, description, kcal);
    productEntity.setList(listEntity);
    return productEntity;
  }


}


