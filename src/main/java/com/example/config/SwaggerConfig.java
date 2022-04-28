package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * link to access to the documentation
 * HTML= http://localhost:8081/swagger-ui/
 */
@Configuration
public class SwaggerConfig{

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Laptop Api rest doc",
                "1.0",
                "https://www.google.com",
                new Contact("Cristian","https://github.com/ccor27","cristian@gmail.com"),
                "MIT",
                "https://www.google.com",
                Collections.emptyList());
    }
}
