package com.alfonso.tasktest.application.mapper;

import com.alfonso.tasktest.domain.entity.Task;
import com.napptilus.openapi.model.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Task response mapper.
 */
@Component
public class TaskResponseMapper {

    /**
     * Mapto list task dto list.
     *
     * @param taskList the task list
     * @return the list
     */
    public List<TaskDTO> maptoListTaskDto (List<Task>taskList){
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task : taskList){
            TaskDTO dto = new TaskDTO();
            dto.setId(task.getId());
            dto.setTitle(task.getTitle());
            dto.setDescription(task.getDescription());
            dto.setStartDate(task.getStartDate());
            dto.setPriority(task.getPriority());
            taskDTOList.add(dto);
        }
        return taskDTOList;
    }

    /**
     * Map to task dto task.
     *
     * @param taskDTO the task dto
     * @return the task
     */
    public Task mapToTaskDto(TaskDTO taskDTO){
        return Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .startDate(taskDTO.getStartDate())
                .priority(taskDTO.getPriority())
                .build();
    }
}
