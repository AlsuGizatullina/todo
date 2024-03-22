package ru.alsu.todo.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardViewResponseDTO {
    private Long boardId;
    private String name;
    private String code;
    private TasksViewResponseDTO tasks;
}
