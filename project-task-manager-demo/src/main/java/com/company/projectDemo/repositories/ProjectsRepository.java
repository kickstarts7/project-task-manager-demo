package com.company.projectDemo.repositories;

import com.company.projectDemo.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Project Repository class for CRUD operations.
 */
public interface ProjectsRepository extends JpaRepository<Project, Long> {
}
