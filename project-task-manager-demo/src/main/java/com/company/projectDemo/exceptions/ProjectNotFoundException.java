package com.company.projectDemo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is my Custom ProjectNotFound class for Project vs Task Tracking system.
 */
@ResponseStatus(value = NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long projectId) {
        super("Project with id: " + projectId + " is not found");
    }
}

