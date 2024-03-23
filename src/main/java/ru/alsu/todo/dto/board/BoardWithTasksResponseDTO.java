package ru.alsu.todo.dto.board;

import lombok.Data;
import ru.alsu.todo.dto.task.TaskResponseDTO;

import java.util.List;

@Data
public class BoardWithTasksResponseDTO {
    private Long boardId;
    private String name;
    private String code;
    private List<TaskResponseDTO> tasks;
}
