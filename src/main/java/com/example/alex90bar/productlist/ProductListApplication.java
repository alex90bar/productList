package com.example.alex90bar.productlist;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableMongock
@SpringBootApplication
public class ProductListApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductListApplication.class, args);
  }

}
