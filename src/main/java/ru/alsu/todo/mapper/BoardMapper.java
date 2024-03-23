package ru.alsu.todo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.alsu.todo.dto.board.BoardRequestDTO;
import ru.alsu.todo.dto.board.BoardResponseDTO;
import ru.alsu.todo.dto.board.BoardViewResponseDTO;
import ru.alsu.todo.dto.board.BoardWithTasksResponseDTO;
import ru.alsu.todo.dto.task.TaskViewResponseDTO;
import ru.alsu.todo.dto.task.TasksViewResponseDTO;
import ru.alsu.todo.model.Board;
import ru.alsu.todo.model.Task;
import ru.alsu.todo.model.TaskStatus;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = TaskMapper.class)
public interface BoardMapper {
    BoardResponseDTO toResponse(Board board);

    BoardWithTasksResponseDTO toAllResponse(Board board);

    Board toEntity(BoardRequestDTO boardRequestDTO);

    List<BoardResponseDTO> toResponse(List<Board> boards);

    TaskViewResponseDTO toTaskResponse(Task task);

    @Mapping(target = "tasks", source = "tasks", qualifiedByName = "tasksToView")
    BoardViewResponseDTO toView(Board board);

    @Named("tasksToView")
    default TasksViewResponseDTO tasksToView(List<Task> tasks){
        TasksViewResponseDTO tasksViewResponseDTO = new TasksViewResponseDTO();
        for (var task: tasks){
            switch (task.getStatus()){
                case TaskStatus.NEW -> {
                   tasksViewResponseDTO.getTasksNew().add(toTaskResponse(task));
                }
                case TaskStatus.IN_PROGRESS -> {
                    tasksViewResponseDTO.getTasksInProgress().add(toTaskResponse(task));
                }
                case TaskStatus.DONE -> {
                    tasksViewResponseDTO.getTasksDone().add(toTaskResponse(task));
                }
            }
        }
        return  tasksViewResponseDTO;
    }
}

