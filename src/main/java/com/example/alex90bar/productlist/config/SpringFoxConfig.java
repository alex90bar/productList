package com.example.alex90bar.productlist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SpringFoxConfig
 *
 * @author alex90bar
 */

@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket docket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.alex90bar.productlist.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("ProductList Server API")
        .version("1.0")
        .description("API for ProductList Server")
        .contact(new Contact("Alexander Baranov", "https://github.com/alex90bar/productList", "alex90bar@gmail.com"))
        .license("Apache License Version 2.0")
        .build();
  }

}


