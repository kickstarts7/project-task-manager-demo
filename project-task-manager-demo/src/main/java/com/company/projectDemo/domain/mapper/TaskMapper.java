package com.company.projectDemo.domain.mapper;

import com.company.projectDemo.domain.dto.task.TaskCreateDto;
import com.company.projectDemo.domain.dto.task.TaskDto;
import com.company.projectDemo.domain.dto.task.TaskUpdateDto;
import com.company.projectDemo.domain.entity.Task;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Task Mapper Class
 */
@Mapper(componentModel = "spring")
public interface TaskMapper {

//    Task toTask(TaskCreateDto taskCreateDto);

    List<TaskDto> toListTaskDto(List<Task> tasks);

    Task fromCreateDto(TaskCreateDto taskCreateDto);

    Task fromUpdateDto(TaskUpdateDto taskUpdateDto);

    TaskDto toTaskDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Task merge(@MappingTarget Task target, Task source);
}
