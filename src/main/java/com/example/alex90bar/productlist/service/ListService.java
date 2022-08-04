package com.example.alex90bar.productlist.service;

import com.example.alex90bar.productlist.api.mapper.ListMapper;
import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.model.List;
import com.example.alex90bar.productlist.repository.ListRepository;
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
  private final ListMapper mapper;


  public void create(ListRq listRq) {
    log.info("create begins " + listRq.toString());

    List list = mapper.mapListRqToList(listRq);
    listRepository.save(list);

    log.info("create ends");
  }
}


