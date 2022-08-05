package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ListMapper;
import com.example.alex90bar.productlist.api.mapper.ProductMapper;
import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.api.response.ListRs;
import com.example.alex90bar.productlist.api.response.ProductRs;
import com.example.alex90bar.productlist.model.List;
import com.example.alex90bar.productlist.model.Product;
import com.example.alex90bar.productlist.repository.ListRepository;
import com.example.alex90bar.productlist.repository.ProductRepository;
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

  private final ListRepository listRepository;
  private final ProductRepository productRepository;
  private final ListMapper mapper;
  private final ProductMapper productMapper;


  public void create(ListRq listRq) {
    log.info("create begins " + listRq.toString());

    List list = mapper.mapListRqToList(listRq);
    listRepository.save(list);

    log.info("create ends");
  }

  public java.util.List<ListRs> getAllLists() {
    log.info("getAllLists begins");

    java.util.List<List> listList = listRepository.findAll();
    java.util.List<ListRs> listRsList = new ArrayList<>();

    //Находим список продуктов по list.id для каждого list и добавляем в response
    for (List list : listList){
      java.util.List<ProductRs> productRsList = productRepository.findAllByListId(list.getId())
          .stream().map(productMapper::mapProductToProductRs).collect(Collectors.toList());

      ListRs listRs = mapper.mapListToListRs(list, productRsList);
      listRsList.add(listRs);
    }

    log.info("getAllLists ends");
    return listRsList;
  }
}


