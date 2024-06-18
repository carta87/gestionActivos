package com.grupo.empresa.gestion_activos.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApiDefinition() {
        return new OpenAPI()
                .info(new Info()
                        .title("Open API Gestion de activos")
                        .version("1.0")
                        .description("Documentacion para consumo de servicios "));
    }
}