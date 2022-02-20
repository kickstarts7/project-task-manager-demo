package com.company.projectDemo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a configuration class for Swagger.
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Basic Project vs Task Tracker System",
        version = "1.0.0",
        description = "This app provides project versus task tracking service"))
public class SwaggerConfiguration {
}
