package com.company.projectDemo.services;

import com.company.projectDemo.domain.entity.Project;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Project Service Interface.
 */
public interface ProjectsService {
    Project get(Long projectId);

    Project create(Project project);

    Project update(Long projectId, Project project);

    void delete(Long projectId);
}
