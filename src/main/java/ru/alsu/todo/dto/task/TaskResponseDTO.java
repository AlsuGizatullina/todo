package ru.alsu.todo.dto.task;

import lombok.Data;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.TaskStatus;

@Data
public class TaskResponseDTO {
    private Long taskId;
    private String name;
    private TaskStatus status;
    private Long boardId;
}
