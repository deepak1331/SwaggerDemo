package com.learn.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/rest/*"))
                .apis(RequestHandlerSelectors.basePackage("com.learn.controller"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Product JPA CRUD Operations API",
                "Practice API for Interview Preparations",
                "1.0",
                "Free to Use",
                new springfox.documentation.service.Contact("Deepak Yadav", "www.oakExplorer.com", "deepakyadav.java@gmail.com"),
                "API License",
                "http://www.oakExplorer.com",
                Collections.emptyList());
    }
}

