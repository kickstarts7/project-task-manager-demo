package com.company.projectDemo.controllers;

import com.company.projectDemo.domain.dto.project.ProjectCreateDto;
import com.company.projectDemo.domain.dto.project.ProjectDto;
import com.company.projectDemo.domain.dto.project.ProjectUpdateDto;
import com.company.projectDemo.domain.mapper.ProjectMapper;
import com.company.projectDemo.exceptions.ProjectNotFoundException;
import com.company.projectDemo.services.ProjectsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a REST API class for Project vs Task Tracking system.
 */
@RestController
@RequestMapping(path = "/projects")
@RequiredArgsConstructor
@Tag(name = "Project", description = "description")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Project not found")
public class ProjectsController {

    private final ProjectsService projectsService;
    private final ProjectMapper projectMapper;

    /**
     * It finds and return a Project on JSON format if Project exists
     *
     * @return a projectDto on JSON format
     */
    @Operation(description = "Find project by id")
    @ApiResponse(responseCode = "200", description = "Project found")
    @ApiResponse(responseCode = "500", description = "Project not found")
    @GetMapping("/{projectId}")
    public ProjectDto get(@PathVariable(name = "projectId") Long projectId) {
        return Optional.of(projectId)
                .map(projectsService::get)
                .map(projectMapper::toProjectDto)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    /**
     * It creates a new Project
     *
     * @return a projectDto on JSON format
     */
    @Operation(description = "Create new project")
    @ApiResponse(responseCode = "200", description = "Project created")
    @PostMapping
    public ProjectDto create(@RequestBody ProjectCreateDto projectCreateDto) {
        return Optional.ofNullable(projectCreateDto)
                .map(projectMapper::fromCreateDto)
                .map(projectsService::create)
                .map(projectMapper::toProjectDto)
                .orElseThrow();
    }

    /**
     * It updates a project if it exists
     *
     * @return a projectDto on JSON format
     */
    @Operation(description = "Update project by id")
    @ApiResponse(responseCode = "200", description = "Project updated")
    @ApiResponse(responseCode = "500", description = "Project not found")
    @PatchMapping("/{projectId}")
    public ProjectDto update(@PathVariable(name = "projectId") Long id,
                             @RequestBody ProjectUpdateDto projectUpdateDto) {
        return Optional.ofNullable(projectUpdateDto)
                .map(projectMapper::fromUpdateDto)
                .map(toUpdate -> projectsService.update(id, toUpdate))
                .map(projectMapper::toProjectDto)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * It removes a Project if it exists
     *
     * @return void
     */
    @Operation(description = "Remove project by id")
    @ApiResponse(responseCode = "204", description = "Project removed")
    @DeleteMapping("/{projectId}")
    @ResponseStatus(value = NO_CONTENT)
    public void delete(@PathVariable(name = "projectId") Long id) {
        projectsService.delete(id);
    }


}
