package com.example.alex90bar.productlist.api.mapper;

import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.api.response.ListRs;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.model.ListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * ListMapper
 *
 * @author alex90bar
 */

@Mapper(componentModel = "spring")
public interface ListMapper {

  @Mapping(target = "id", ignore = true)
  ListEntity mapListRqToListEntity (ListRq listRq);

  @Mapping(target = "name", source = "listEntity.name")
  @Mapping(target = "products", source = "productRsList")
  @Mapping(target = "totalKcal", expression = ("java(calculateKcal(productRsList))"))
  ListRs mapListEntityToListRs(ListEntity listEntity, java.util.List<ProductRs> productRsList);

  //суммируем калории из списка продуктов
  default Integer calculateKcal(java.util.List<ProductRs> productRsList){
    return productRsList.stream().mapToInt(ProductRs::getKcal).sum();
  }


}
