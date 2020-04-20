package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ResthibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResthibernatejpaApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(Predicates.or( PathSelectors.regex("/students/*"),PathSelectors.regex("/teachers/*"))) 
				//.build() .pathMapping("/")
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/students/*"))
				//.paths(PathSelectors.ant("/teachers/*"))
				//.paths(PathSelectors.ant("/departments/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.build();
	}

}
