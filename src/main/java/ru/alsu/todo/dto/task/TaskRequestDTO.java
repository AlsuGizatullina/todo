package ru.alsu.todo.dto.task;

import lombok.Data;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.TaskStatus;

@Data
public class TaskRequestDTO {
    private String name;
    private Long boardId;
}
