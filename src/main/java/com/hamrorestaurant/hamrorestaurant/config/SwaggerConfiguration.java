package com.hamrorestaurant.hamrorestaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.scanners.ApiDocumentationScanner;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {

    @Bean
    public  Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hamrorestaurant"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());

    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("HamroRestaurant - Swagger Documentation")
                .description("Swagger- HamroRestaurant Application")
                .build();
    }
}
