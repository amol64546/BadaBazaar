//package com.BadaBazaar.BadaBazaar.Config;
//
//
//import static springfox.documentation.builders.PathSelectors.any;
//import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;
//import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
//
//import javax.servlet.ServletContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.spring.web.paths.RelativePathProvider;
//
///**
// * Swagger configuration
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    /**
//     * Setting up swagger docket
//     *
//     * @return swagger docket
//     */
//    @Bean
//    public Docket swagger(ServletContext servletContext) {
//
//        return new Docket(SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder().title("BadaBazaar").version("1").build())
//                .select()
//                .apis(withClassAnnotation(RestController.class))
//                .paths(any())
//                .build()
//                .pathProvider(new RelativePathProvider(servletContext) {
//                    @Override
//                    public String getApplicationBasePath() {
//                        return "/BadaBazaar";
//                    }
//                });
//    }
//}
