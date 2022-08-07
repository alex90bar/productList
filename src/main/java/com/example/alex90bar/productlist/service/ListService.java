package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ListMapper;
import com.example.alex90bar.productlist.api.mapper.ProductMapper;
import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.api.response.ListRs;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.exception.ListAlreadyExistException;
import com.example.alex90bar.productlist.model.ListEntity;
import com.example.alex90bar.productlist.repository.ListEntityRepository;
import com.example.alex90bar.productlist.repository.ProductEntityRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ListService
 *
 * @author alex90bar
 */

@Slf4j
@Service
@AllArgsConstructor
public class ListService {

  private final ListEntityRepository listEntityRepository;
  private final ProductEntityRepository productEntityRepository;
  private final ListMapper mapper;
  private final ProductMapper productMapper;


  public void create(ListRq listRq) {
    log.info("create begins " + listRq.toString());

    //Проверяем, есть ли List с таким именем в базе, если нет - создаем.
    if (listEntityRepository.existsByName(listRq.getName())){
      throw new ListAlreadyExistException("List with name: " + listRq.getName()
          + " = already exists. Please, correct the name");
    }

    ListEntity listEntity = mapper.mapListRqToListEntity(listRq);
    listEntityRepository.insert(listEntity);

    log.info("create ends");
  }

  public java.util.List<ListRs> getAllLists() {
    log.info("getAllLists begins");
    java.util.List<ListEntity> listEntityList = listEntityRepository.findAll();

    java.util.List<ListRs> listRsList = new ArrayList<>();

    //Находим список продуктов по list.id для каждого list и добавляем в response
    for (ListEntity listEntity : listEntityList){
      java.util.List<ProductRs> productRsList = productEntityRepository.findAllByListId(listEntity.getId())
          .stream().map(productMapper::mapProductEntityToProductRs).collect(Collectors.toList());

      ListRs listRs = mapper.mapListEntityToListRs(listEntity, productRsList);
      listRsList.add(listRs);
    }

    log.info("getAllLists ends");
    return listRsList;

  }
}


