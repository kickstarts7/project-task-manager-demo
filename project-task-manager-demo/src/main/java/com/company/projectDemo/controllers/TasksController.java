package com.company.projectDemo.controllers;

import com.company.projectDemo.domain.dto.task.TaskCreateDto;
import com.company.projectDemo.domain.dto.task.TaskDto;
import com.company.projectDemo.domain.dto.task.TaskUpdateDto;
import com.company.projectDemo.domain.mapper.TaskMapper;
import com.company.projectDemo.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a REST API class for Project vs Task Tracking system.
 */
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;
    private final TaskMapper taskMapper;

    /**
     * Return list of TasksDto on JSON format of a given Project
     *
     * @return tasks on JSON format
     */
    @GetMapping(path = "/projects/{projectId}/tasks")
    public List<TaskDto> get(@PathVariable Long projectId) {
        return Optional.of(projectId)
                .map(tasksService::getAllTasksOfProject)
                .map(taskMapper::toListTaskDto)
                .orElseThrow();
    }

    /**
     * It creates a task for a given Project
     *
     * @return a created TaskDto on JSON format
     */
    @PostMapping(path = "/projects/{projectId}/tasks")
    public TaskDto create(@RequestBody TaskCreateDto taskCreateDto,
                          @PathVariable Long projectId) {
        return Optional.ofNullable(taskCreateDto)
                .map(taskMapper::fromCreateDto)
                .map(it -> tasksService.create(projectId, it))
                .map(taskMapper::toTaskDto)
                .orElseThrow();
    }

    /**
     * It updates a task and return a TaskDto on JSON format
     *
     * @return tasks on JSON format
     */
    @PatchMapping("/tasks/{taskId}")
    public TaskDto update(@PathVariable Long taskId, @RequestBody TaskUpdateDto taskUpdateDto) {
        return Optional.of(taskUpdateDto)
                .map(taskMapper::fromUpdateDto)
                .map(it -> tasksService.update(taskId, it))
                .map(taskMapper::toTaskDto)
                .orElseThrow();
    }

    /**
     * It deletes a task of a given Project
     *
     * @return void
     */
    @DeleteMapping("/projects/{projectId}/tasks/{taskId}")
    public void delete(@PathVariable Long projectId,
                       @PathVariable Long taskId) {
        tasksService.delete(projectId, taskId);
    }
}
