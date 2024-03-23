package ru.alsu.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alsu.todo.model.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByUserUserId(Long userId);
}
