package com.solutis.car.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select() // Seleciona os endpoints que serão documentados
                .apis(RequestHandlerSelectors.basePackage("com.solutis.car.controller")) // Filtra por pacote
                .paths(PathSelectors.any()) // Filtra por path
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Solutis Car API")
                .description("Documentação da API de acesso aos endpoints do Solutis Car.")
                .version("1.0")
                .build();
    }
}
