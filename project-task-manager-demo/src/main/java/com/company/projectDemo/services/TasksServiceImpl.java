package com.company.projectDemo.services;

import com.company.projectDemo.domain.entity.Project;
import com.company.projectDemo.domain.entity.Task;
import com.company.projectDemo.domain.mapper.TaskMapper;
import com.company.projectDemo.exceptions.ProjectNotFoundException;
import com.company.projectDemo.exceptions.TaskNotFoundException;
import com.company.projectDemo.repositories.ProjectsRepository;
import com.company.projectDemo.repositories.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Task Service Class for business logic.
 * Operations are provided: getting all tasks of a project, creating a task, updating and deleting it
 */
@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<Task> getAllTasksOfProject(Long projectId) {
        if (projectsRepository.findById(projectId).isPresent()) {
            return tasksRepository.findTasksByProject_Id(projectId);
        } else {
            throw new ProjectNotFoundException(projectId);
        }
    }

    @Override
    public Task create(Long projectId, Task task) {
        Project project = projectsRepository.getById(projectId);
        project.addTasks(task);
        return tasksRepository.save(task);
    }

    @Override
    public Task update(Long taskId, Task task) {
        return Optional.of(taskId)
                .map(tasksRepository::getById)
                .map(current -> taskMapper.merge(current, task))
                .map(tasksRepository::save)
                .orElseThrow();
    }

    @Override
    public void delete(Long projectId, Long taskId) {
        final Task toDelete = tasksRepository.findById(taskId).
                orElseThrow(() -> new TaskNotFoundException(taskId));
        Project project = projectsRepository.getById(projectId);
        project.removeTasks(toDelete);
        projectsRepository.save(project);
    }
}
