package ru.alsu.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.alsu.todo.dto.BoardRequestDTO;
import ru.alsu.todo.dto.BoardResponseDTO;
import ru.alsu.todo.dto.BoardViewResponseDTO;
import ru.alsu.todo.dto.BoardWithTasksResponseDTO;
import ru.alsu.todo.mapper.BoardMapper;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @PostMapping
    private BoardResponseDTO create(@RequestBody BoardRequestDTO boardRequestDTO){
        Board board = boardService.save(boardMapper.toEntity(boardRequestDTO));
        return boardMapper.toResponse(board);
    }

    @GetMapping("/{boardId}")
    private BoardWithTasksResponseDTO getById(@PathVariable Long boardId){
        Board board = boardService.getById(boardId);
        return boardMapper.toAllResponse(board);
    }

    @GetMapping("/{boardId}/view")
    private BoardViewResponseDTO getByIdView(@PathVariable Long boardId){
        Board board = boardService.getById(boardId);
        return boardMapper.toView(board);
    }

    @GetMapping
    private List<BoardResponseDTO> getAll(){
        List<Board> boards = boardService.getAll();
        return boardMapper.toResponse(boards);
//        return boards.stream().map(boardMapper::toResponse).toList();
    }

    @DeleteMapping("/{boardId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long boardId){
        boardService.deleteById(boardId);
    }
}
