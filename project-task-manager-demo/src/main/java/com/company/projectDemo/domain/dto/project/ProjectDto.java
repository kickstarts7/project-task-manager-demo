package com.company.projectDemo.domain.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a ProjectDto class for Project vs Task Tracking system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {

    private String projectName;
}
