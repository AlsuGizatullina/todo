package ru.alsu.todo.dto.board;

import lombok.Data;
import ru.alsu.todo.dto.task.TasksViewResponseDTO;

@Data
public class BoardViewResponseDTO {
    private Long boardId;
    private String name;
    private String code;
    private TasksViewResponseDTO tasks;
}
