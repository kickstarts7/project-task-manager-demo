package com.company.projectDemo.domain.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a TaskCreateDto class for Project vs Task Tracking system.
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class TaskCreateDto {
    String taskName;
    String description;
}
