package com.company.projectDemo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is my Custom TaskNotFound class for Project vs Task Tracking system.
 */
@ResponseStatus(value = NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long taskId) {
        super("Task with id: " + taskId + " is not found");
    }
}
