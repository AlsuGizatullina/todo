package ru.alsu.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.Task;
import ru.alsu.todo.model.TaskStatus;
import ru.alsu.todo.model.User;
import ru.alsu.todo.repository.BoardRepository;
import ru.alsu.todo.repository.TaskRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardService boardService;
    private final UserService userService;

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
        User user = userService.getCurrentUser();
        Task task = taskRepository.findById(taskId).orElseThrow();
        User userTask = task.getBoard().getUser();
        if (Objects.equals(user.getUserId(), userTask.getUserId())){
            return task;
        } else {
            throw new RuntimeException("No access");
        }
    }

    public void deleteById(Long taskId){
        Task task = getById(taskId);
        taskRepository.deleteById(task.getTaskId());
    }

    public Task changeStatus(Long taskId, TaskStatus status){
        Task task = getById(taskId);
        task.setStatus(status);
        return save(task);
    }
}
