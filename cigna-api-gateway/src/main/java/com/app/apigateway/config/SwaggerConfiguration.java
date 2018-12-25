package com.app.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;

/**
 * Created by Vijay Jejurkar on 13th Oct 2018.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.apigateway.controller"))
                .build().apiInfo(new ApiInfo("Api-Gateway",
                        "",
                        "1.0",
                        "", new Contact("","",""),
                        null, null, new ArrayList<>()));
    }
	/*@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}


	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {
		return or( regex("/rest/db.*")
				,regex("/login.*")
				,regex("/users.*"));
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Gateway Service system API's")
				.description("Gateway service API's for developers")
				.version("1.0").build();
	}*/
}
