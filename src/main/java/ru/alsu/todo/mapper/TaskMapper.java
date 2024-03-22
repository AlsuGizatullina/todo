package ru.alsu.todo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.alsu.todo.dto.TaskRequestDTO;
import ru.alsu.todo.dto.TaskResponseDTO;
import ru.alsu.todo.model.Task;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    Task toEntity(TaskRequestDTO taskRequestDTO);

    @Mapping(target = "boardId", source = "board.boardId")
    TaskResponseDTO toResponse(Task task);

    List<TaskResponseDTO> toResponse(List<Task> tasks);
}
