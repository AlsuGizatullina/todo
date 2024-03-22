package ru.alsu.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.alsu.todo.dto.TaskRequestDTO;
import ru.alsu.todo.dto.TaskResponseDTO;
import ru.alsu.todo.mapper.TaskMapper;
import ru.alsu.todo.model.Task;
import ru.alsu.todo.model.TaskStatus;
import ru.alsu.todo.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskRequestDTO taskRequestDTO){
        Task task = taskMapper.toEntity(taskRequestDTO);
        return taskMapper.toResponse(taskService.create(task, taskRequestDTO.getBoardId()));
    }

    @GetMapping("/{taskId}")
    public TaskResponseDTO getById(@PathVariable Long taskId){
        Task task = taskService.getById(taskId);
        return taskMapper.toResponse(task);
    }

    @PatchMapping("/{taskId}/{taskStatus}")
    public TaskResponseDTO changeStatus(@PathVariable Long taskId, @PathVariable TaskStatus taskStatus){
        Task task = taskService.changeStatus(taskId, taskStatus);
        return taskMapper.toResponse(task);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long taskId){
        taskService.deleteById(taskId);
    }
}
