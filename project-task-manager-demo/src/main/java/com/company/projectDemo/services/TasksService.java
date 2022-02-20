package com.company.projectDemo.services;

import com.company.projectDemo.domain.entity.Task;

import java.util.List;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Task Service Interface.
 */
public interface TasksService {
    List<Task> getAllTasksOfProject(Long projectId);

    Task create(Long projectId, Task task);

    Task update(Long taskId, Task task);

    void delete(Long projectId, Long taskId);
}
