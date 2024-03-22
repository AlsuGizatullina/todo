package ru.alsu.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alsu.todo.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
