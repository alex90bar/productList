package com.example.alex90bar.productlist.api.mapper;

import com.example.alex90bar.productlist.api.request.ProductRq;
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

}
