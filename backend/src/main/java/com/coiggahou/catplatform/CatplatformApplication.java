package com.coiggahou.catplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.coiggahou.catplatform.mapper")
@EnableSwagger2
public class CatplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatplatformApplication.class, args);
	}

}
