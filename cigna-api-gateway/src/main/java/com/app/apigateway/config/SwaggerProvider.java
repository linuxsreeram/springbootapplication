package com.app.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay Jejurkar on 13th Oct 2018.
 */
@Component
@Primary
@EnableAutoConfiguration
public class SwaggerProvider implements SwaggerResourcesProvider {
  private static final Logger log = LoggerFactory
      .getLogger(SwaggerProvider.class);

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public List get() {
    List resources = new ArrayList<>();
    try {
      // Keep alpha-beta order
      resources.add(swaggerResource("db-service",
              "/api/db-service/v2/api-docs", "1.0"));
          resources.add(swaggerResource("stock-service",
              "/api/stock-service/v2/api-docs", "1.0"));
      resources.add(swaggerResource("api-gateway",
              "/v2/api-docs", "1.0"));

    } catch (Exception ex) {
      log.error(ex.getLocalizedMessage());
    }
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);

    return swaggerResource;
  }

  @Bean
  UiConfiguration uiConfig() {
    return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
        UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
  }
}
