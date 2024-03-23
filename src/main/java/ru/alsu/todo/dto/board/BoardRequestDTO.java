package ru.alsu.todo.dto.board;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.alsu.todo.model.Task;

import java.util.List;

@Data
public class BoardRequestDTO {
    private String name;
    private String code;
}
