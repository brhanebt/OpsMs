package com.springprojects.shipmentmicroservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApiConfig(){
        return new OpenAPI()
                .info(new Info()
                        .title("Shipment Microservice API")
                        .description("API documentation for the Shipment Microservice")
                        .version("1.0.0"));
    }
}
