package com.company.projectDemo;

import com.company.projectDemo.domain.entity.Project;
import com.company.projectDemo.domain.mapper.ProjectMapper;
import com.company.projectDemo.exceptions.ProjectNotFoundException;
import com.company.projectDemo.repositories.ProjectsRepository;
import com.company.projectDemo.services.ProjectsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProjectsServiceUnitTest {

    @InjectMocks
    private ProjectsServiceImpl projectsServiceImpl;

    @Mock
    private ProjectsRepository projectsRepository;
    @Mock
    private ProjectMapper projectMapper;

    Project project = new Project();

    @BeforeEach
    public void initData() {
        project.setId(1L);
        project.setProjectName("Maven project");
    }

    @Test
    public void testProjectNotFoundById() {
        Mockito.when(projectsRepository.findById(project.getId())).thenReturn(Optional.empty());
        try {
            projectsServiceImpl.get(project.getId());
            fail();
        } catch (ProjectNotFoundException e) {
            Assertions.assertEquals("Project with id: " + project.getId() + " is not found", e.getMessage());
        }
    }

    @Test
    public void testGetProjectById() {
        Mockito.when(projectsRepository.findById(project.getId())).thenReturn(Optional.of(project));
        Assertions.assertEquals(projectsServiceImpl.get(project.getId()), project);
    }

    @Test
    public void testCreateProject() {
        Mockito.when(projectsRepository.save(project)).thenReturn(project);
        Assertions.assertEquals(projectsServiceImpl.create(project), project);
    }

    @Test
    public void testDeleteProject() {
        projectsServiceImpl.delete(project.getId());
        verify(projectsRepository, times(1)).deleteById(project.getId());
    }

    @Test()
    public void testUpdateProject() {
        Project updatedProject = new Project();
        updatedProject.setId(1L);
        updatedProject.setProjectName("Spring MVC Project");
        Mockito.when(projectsRepository.findById(project.getId())).thenReturn(Optional.of(project));
        Mockito.when(projectMapper.merge(project, updatedProject)).thenReturn(updatedProject);
        Mockito.when(projectsRepository.save(updatedProject)).thenReturn(updatedProject);
        projectsServiceImpl.update(project.getId(), updatedProject);
        verify(projectsRepository, times(1)).save(updatedProject);

    }
}
