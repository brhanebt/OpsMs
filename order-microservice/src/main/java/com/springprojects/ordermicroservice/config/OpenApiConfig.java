package com.springprojects.ordermicroservice.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApiConfigCustom(){
        return new OpenAPI()
                .info(new Info()
                        .title("Order Microservice API")
                        .description("API documentation for the Order Microservice")
                        .version("1.0.0"));
    }
}
