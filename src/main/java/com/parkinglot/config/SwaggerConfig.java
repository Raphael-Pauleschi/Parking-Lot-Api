package com.parkinglot.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 * For some reason swagger doesn't work in my device
 */
/*
@Component
@EnableSwagger2
@EnableWebMvc
*/
public class SwaggerConfig {
/*
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.parkinglot.controller"))
				.build()
				.apiInfo(metaData())
				.securitySchemes(Arrays.asList(apiKey()));
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Parking Lot REST API")
				.description("Spring Boot REST API for parking")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0/--")
				.build();
	}
	
	 private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
	*/
}
