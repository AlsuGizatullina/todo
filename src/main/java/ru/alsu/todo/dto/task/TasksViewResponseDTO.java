package ru.alsu.todo.dto.task;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TasksViewResponseDTO {
    private List<TaskViewResponseDTO> tasksNew = new ArrayList<>();
    private List<TaskViewResponseDTO> tasksInProgress = new ArrayList<>();
    private List<TaskViewResponseDTO> tasksDone = new ArrayList<>();
}
