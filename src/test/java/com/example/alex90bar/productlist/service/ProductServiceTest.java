package com.example.alex90bar.productlist.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.alex90bar.productlist.api.request.ProductRq;
import com.example.alex90bar.productlist.api.request.ProductToListRq;
import com.example.alex90bar.productlist.exception.ListNotFoundException;
import com.example.alex90bar.productlist.exception.ProductAlreadyExistException;
import com.example.alex90bar.productlist.exception.ProductAlreadyInListException;
import com.example.alex90bar.productlist.model.ListEntity;
import com.example.alex90bar.productlist.model.ProductEntity;
import com.example.alex90bar.productlist.repository.ListEntityRepository;
import com.example.alex90bar.productlist.repository.ProductEntityRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class ProductServiceTest {

  @Autowired
  private ProductService productService;

  @MockBean
  private ProductEntityRepository productRepository;

  @MockBean
  private ListEntityRepository listRepository;

  @Test
  public void notExistListTest(){
    when(listRepository.findListByName(anyString())).thenThrow(ListNotFoundException.class);
    assertThrows(ListNotFoundException.class,
        () -> productService.putProductToList(new ProductToListRq()));
  }

  @Test
  public void productAlreadyInListTest(){
    ListEntity list = new ListEntity();
    list.setName("Spirits");

    ProductEntity product = new ProductEntity();
    product.setName("Jameson");
    product.setList(list);

    ProductToListRq productToListRq = new ProductToListRq();
    productToListRq.setProductName(product.getName());
    productToListRq.setListName(list.getName());

    when(listRepository.findListByName("Spirits")).thenReturn(java.util.Optional.of(list));
    when(productRepository.findByName("Jameson")).thenReturn(java.util.Optional.of(product));

    assertThrows(ProductAlreadyInListException.class, () -> productService.putProductToList(productToListRq));
  }

  @Test
  public void productAlreadyExistsTest(){
    ProductRq productRq = new ProductRq();
    productRq.setName("Cookie");

    when(productRepository.existsByName("Cookie")).thenThrow(ProductAlreadyExistException.class);
    assertThrows(ProductAlreadyExistException.class, () -> productService.create(productRq));

  }


}