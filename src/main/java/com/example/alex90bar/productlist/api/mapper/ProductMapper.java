package com.example.alex90bar.productlist.api.mapper;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * ProductMapper
 *
 * @author alex90bar
 */

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  ProductEntity mapProductRqToProductEntity(ProductRq productRq);

  @Mapping(target = "list", expression = ("java(checkListed(productEntity))"))
  ProductRs mapProductEntityToProductRs(ProductEntity productEntity);

  //если продукт не добавлен в лист - возвращаем в response поле с комментарием об этом,
  // иначе - название листа
  default String checkListed(ProductEntity productEntity){
    return productEntity.getList() == null ? "Product isn't in any list" : productEntity.getList().getName();
  }

}
