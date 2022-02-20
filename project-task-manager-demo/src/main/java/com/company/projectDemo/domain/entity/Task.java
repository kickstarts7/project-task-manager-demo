package com.company.projectDemo.domain.entity;

import lombok.*;

import javax.persistence.*;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Task Entity Class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
