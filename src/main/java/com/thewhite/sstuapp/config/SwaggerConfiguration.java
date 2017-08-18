package com.thewhite.sstuapp.config;

import com.thewhite.sstuapp.service.dto.ErrorDTO;
import io.swagger.annotations.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
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
                ).globalResponseMessage(RequestMethod.GET,
                        newArrayList(
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message("The request was invalid or cannot be otherwise served.")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(401)
                                        .message("Authentication credentials were missing or incorrect.")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("Internal server error")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("The request is understood, but it has been refused or access is not allowed.")
                                        .build()));
//        @ApiResponse(code = 400, message = "", response = ErrorDTO.class),
//        @ApiResponse(code = 401, message = "", response = ErrorDTO.class),
//        @ApiResponse(code = 403, message = "The request is understood, but it has been refused or access is not allowed.", response = ErrorDTO.class),
//        @ApiResponse(code = 404, message = "The URI requested is invalid or the resource requested does not exists.", response = ErrorDTO.class),
//        @ApiResponse(code = 409, message = "Any message which should help the user to resolve the conflict.", response = ErrorDTO.class),
//        @ApiResponse(code = 429, message = "The request cannot be served due to the application’s rate limit having been exhausted for the resource.", response = ErrorDTO.class),
//        @ApiResponse(code = 500, message = "Что.", response = ErrorDTO.class),
//        @ApiResponse(code = 503, message = "The server is up, but overloaded with requests. Try again later.", response = ErrorDTO.class)

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