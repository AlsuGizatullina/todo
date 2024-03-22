package ru.alsu.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.TaskStatus;
import ru.alsu.todo.repository.BoardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board getById(Long boardId){
        return boardRepository.findById(boardId).orElseThrow();
    }

    public List<Board> getAll(){
        return boardRepository.findAll();
    }

    public void deleteById(Long boardId){
        boardRepository.deleteById(boardId);
    }
}
