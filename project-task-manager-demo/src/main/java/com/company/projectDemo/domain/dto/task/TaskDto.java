package com.company.projectDemo.domain.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a TaskDto class for Project vs Task Tracking system.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskDto {
    private Long id;
    private String taskName;
    private String description;
}