package com.company.projectDemo.domain.mapper;

import com.company.projectDemo.domain.dto.project.ProjectCreateDto;
import com.company.projectDemo.domain.dto.project.ProjectDto;
import com.company.projectDemo.domain.dto.project.ProjectUpdateDto;
import com.company.projectDemo.domain.entity.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Project Mapper Class
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toProject(ProjectCreateDto createProjectDto);

    ProjectDto toProjectDto(Project project);

    Project fromCreateDto(ProjectCreateDto projectCreateDto);

    Project fromUpdateDto(ProjectUpdateDto projectUpdateDto);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Project merge(@MappingTarget Project target, Project source);

}
