package com.example.alex90bar.productlist.api.mapper;

import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.api.response.ListRs;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.model.List;
import com.example.alex90bar.productlist.model.Product;
import java.util.stream.Collectors;
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
  List mapListRqToList (ListRq listRq);

  @Mapping(target = "name", source = "list.name")
  @Mapping(target = "products", source = "productRsList")
  @Mapping(target = "totalKcal", expression = ("java(calculateKcal(productRsList))"))
  ListRs mapListToListRs(List list, java.util.List<ProductRs> productRsList);

  //суммируем калории из списка продуктов
  default Integer calculateKcal(java.util.List<ProductRs> productRsList){
    return productRsList.stream().mapToInt(ProductRs::getKcal).sum();
  }


}
