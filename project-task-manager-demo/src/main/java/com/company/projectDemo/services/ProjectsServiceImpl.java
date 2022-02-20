package com.company.projectDemo.services;

import com.company.projectDemo.domain.entity.Project;
import com.company.projectDemo.domain.mapper.ProjectMapper;
import com.company.projectDemo.exceptions.ProjectNotFoundException;
import com.company.projectDemo.repositories.ProjectsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Project Service Class for business logic.
 * Operations are provided: getting a project by Id, creating a task, updating and deleting it
 */
@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    private final ProjectsRepository projectsRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Project get(Long projectId) {
        return projectsRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @Override
    public Project create(Project project) {
        return projectsRepository.save(project);
    }

    @Override
    public Project update(Long id, Project project) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> projectMapper.merge(current, project))
                .map(projectsRepository::save)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        projectsRepository.deleteById(id);
    }
}
