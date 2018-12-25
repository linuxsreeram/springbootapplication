package com.app.dbservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)/*.groupName("public-api")*/
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}


	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {
		return or( regex("/db.*")
				/*,regex("/login.*")*/
				/*,regex("/users.*")*/);
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Cigna DB API's")
				.description("Cigna DB API's for developers")
				.version("1.0").build();
	}

}
