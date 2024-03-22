package ru.alsu.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.Task;
import ru.alsu.todo.model.TaskStatus;
import ru.alsu.todo.repository.BoardRepository;
import ru.alsu.todo.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardService boardService;

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task create(Task task, Long boardId){
        Board board = boardService.getById(boardId);
        task.setBoard(board);
        task.setStatus(TaskStatus.NEW);
        return save(task);
    }

    public Task getById(Long taskId){
        return taskRepository.findById(taskId).orElseThrow();
    }

    public List<Task> getAll(Long boardId){
        return taskRepository.findAllByBoardBoardId(boardId);
    }

    public void deleteById(Long taskId){
        taskRepository.deleteById(taskId);
    }

    public Task changeStatus(Long taskId, TaskStatus status){
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(status);
        return save(task);
    }
}
