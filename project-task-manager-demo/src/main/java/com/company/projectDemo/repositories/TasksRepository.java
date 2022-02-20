package com.company.projectDemo.repositories;

import com.company.projectDemo.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Task Repository class for CRUD operations.
 */
public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByProject_Id(Long projectId);
}
