package com.coiggahou.catplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Value("${spring.profiles.active:NA}")
    private String active;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable("dev".equals(active))
                .apiInfo(apiInfo())
                .host("localhost:9000")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coiggahou.catplatform.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("校园猫管理平台 - API文档")
                .description("校园猫管理平台 - 接口文档")
                .contact(new Contact(
                        "Coiggahou2002",
                        "https://github.com/Coiggahou2002",
                        "coiggahou@foxmail.com"
                ))
                .version("1.0")
                .build();
    }
}