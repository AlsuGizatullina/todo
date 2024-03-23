package ru.alsu.todo.dto.board;

import lombok.Data;
import ru.alsu.todo.model.Task;

import java.util.List;

@Data
public class BoardResponseDTO {
    private Long boardId;
    private String name;
    private String code;
}
