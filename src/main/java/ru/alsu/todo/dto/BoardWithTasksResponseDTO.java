package ru.alsu.todo.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardWithTasksResponseDTO {
    private Long boardId;
    private String name;
    private String code;
    private List<TaskResponseDTO> tasks;
}
