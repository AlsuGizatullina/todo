package ru.alsu.todo.dto;

import lombok.Data;

@Data
public class TaskViewResponseDTO {
    private Long taskId;
    private String name;
}
