package ru.alsu.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alsu.todo.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByBoardBoardId(Long boardId);
}
