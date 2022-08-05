package com.example.alex90bar.productlist.api.mapper;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.model.Product;
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
  Product mapProductRqToProduct(ProductRq productRq);

  @Mapping(target = "list", expression = ("java(checkListed(product))"))
  ProductRs mapProductToProductRs(Product product);

  //если продукт не добавлен в лист - возвращаем в response поле с комментарием об этом,
  // иначе - название листа
  default String checkListed(Product product){
    return product.getList() == null ? "Product isn't in any list" : product.getList().getName();
  }

}
