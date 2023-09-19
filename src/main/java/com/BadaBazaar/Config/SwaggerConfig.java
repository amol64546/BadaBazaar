package com.BadaBazaar.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Setting up swagger docket
     *
     * @return swagger docket
     */
    @Bean
    public Docket productApi(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.BadaBazaar")).paths(regex("/.*")).build()
                .groupName("Swagger").apiInfo(apiInfo()).pathMapping(getDocumentationPath());
    }

    protected String getDocumentationPath() {
        return "/badabazaar";
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Your API Title",
                "Your API Description",
                "API Version",
                "Terms of service",
                "Your Name",
                "License of API",
                "API license URL"
        );
    }
}
