package com.company.projectDemo.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

/**
 * by Aydar Zakirov
 * since 17.02.2022
 * This is a Project Entity Class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;

    @OneToMany(mappedBy = "project",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH}
    )
    private List<Task> tasks = new ArrayList<>();

    public void addTasks(Task task) {
        this.tasks.add(task);
        task.setProject(this);
    }

    public void removeTasks(Task task) {
        this.tasks.remove(task);
    }

}




