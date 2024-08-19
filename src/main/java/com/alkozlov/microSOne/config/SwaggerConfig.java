package com.alkozlov.microSOne.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.awt.SystemColor.info;

@Configuration
public class SwaggerConfig {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers( List.of(
                        new Server()
                                .url("http://localhost:8080")))
                .info(new Info().title("Cats API"));
    }
}
