package br.com.mrb.service.tasks.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "Task")
@Data
@Table(name = "task")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime dueDate;
    private String email;
    private boolean notified;

}
