package com.aidtaas.mobius.template.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        log.info("-----creating swagger config bean for groupOpenApi-----");
        return new OpenAPI()
                .info((new Info().title("Template-Service")
                        .description("Template-Service APIs")
                        .version("v1.0").termsOfService("Backend service use only")
                        .description("Template-Service controller")));
    }

}