package com.company.projectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Main Class for starting up a Project
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ProjectTaskManagerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTaskManagerDemoApplication.class, args);
    }

}
