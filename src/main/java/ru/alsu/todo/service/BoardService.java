package ru.alsu.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.TaskStatus;
import ru.alsu.todo.model.User;
import ru.alsu.todo.repository.BoardRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserService userService;
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board create(Board board){
        board.setUser(userService.getCurrentUser());
        return save(board);
    }

    public Board getById(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        User user = userService.getCurrentUser();
        User userBoard = board.getUser();
        if (Objects.equals(user.getUserId(), userBoard.getUserId())){
            return board;
        } else {
            throw new RuntimeException("No access");
        }
    }

    public List<Board> getAll(){
        User user = userService.getCurrentUser();
        return user.getBoards();
    }

    public void deleteById(Long boardId){
        Board board = getById(boardId);
        boardRepository.deleteById(board.getBoardId());
//        User user = userService.getCurrentUser();
//        Board board = user.getBoards().stream().filter(board1 -> board1.getBoardId().equals(boardId)).findAny().orElseThrow();
//        boardRepository.deleteById(board.getBoardId());
    }
}
