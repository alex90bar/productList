package com.example.alex90bar.productlist.controller;

import com.example.alex90bar.productlist.api.request.ListRq;
import com.example.alex90bar.productlist.api.response.ListRs;
import com.example.alex90bar.productlist.service.ListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ListController
 *
 * @author alex90bar
 */

@Transactional
@Api(description = "Работа с List, создание и получение")
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/list")
public class ListController {

  private final ListService listService;

  @ApiOperation("Создание нового List в БД, проверяет на наличие по названию")
  @PostMapping
  public ResponseEntity<String> create(@Valid @RequestBody ListRq listRq){
    listService.create(listRq);
    return new ResponseEntity<>("List created succesfully", HttpStatus.OK);
  }

  @ApiOperation("Получение всех существующих List, включая список всех Product по каждому List, и суммарное количество kcal по каждому List")
  @GetMapping
  public List<ListRs> getAllLists(){
    return listService.getAllLists();
  }

}


