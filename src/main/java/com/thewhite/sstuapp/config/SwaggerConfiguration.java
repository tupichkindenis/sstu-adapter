package com.thewhite.sstuapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.*;
import static com.google.common.base.Predicates.*;

/**
 * Created by tupichkindenis on 16.08.17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .groupName("business-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thewhite.sstuapp.web.rest"))
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
                .tags(
                        new Tag("Department service", "All apis relating to departments."),
                        new Tag("Subject service", "All apis relating to subjects."),
                        new Tag("Handling report service", "All apis relating to handling report.")
                );
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "ССТУ.РФ",
                "Описание АПИ для работы с коннектором.",
                "0.0.1",
                "Terms of service",
                 new Contact("Denis Tupichkin"
                            ,""
                            ,"denis.tupichkin@white-soft.ru"),
                "License of API",
                "API license URL",
                new ArrayList<>());
        return apiInfo;
    }

    private com.google.common.base.Predicate<String> paths() {
        return or(
                    regex("/departments.*"),
                    regex("/subjects.*"),
                    regex("/handling-report.*")
                 );
    }
}