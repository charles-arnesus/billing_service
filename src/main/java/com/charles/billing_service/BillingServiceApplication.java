package com.charles.billing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/biller/*"))
				.apis(RequestHandlerSelectors.basePackage("com.charles.billing_service"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Billing Payment API",
				"API documentations for Billing Payment application",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Charles Arnesus", "https://www.mitrais.com/", "charlesarnesus.matulessy@mitrais.com"),
				"API License",
				"https://www.mitrais.com/",
				Collections.emptyList()
				);
	}

}
