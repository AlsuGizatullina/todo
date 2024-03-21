package ru.alsu.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long taskId;

    @Column
    private String name;

    @Column
    private TaskStatus status;
}
