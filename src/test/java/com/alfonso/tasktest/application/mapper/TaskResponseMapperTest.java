package com.alfonso.tasktest.application.mapper;

import com.alfonso.tasktest.domain.entity.Task;
import com.napptilus.openapi.model.TaskDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskResponseMapperTest {

    @InjectMocks
    private TaskResponseMapper taskResponseMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMaptoListTaskDto() {
        Task task1 = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        Task task2 = Task.builder()
                .id(2)
                .title("Task 2")
                .description("Description 2")
                .startDate("2020-06-14")
                .priority(2)
                .build();

        List<Task> taskList = Arrays.asList(task1, task2);

        List<TaskDTO> taskDTOList = taskResponseMapper.maptoListTaskDto(taskList);

        assertNotNull(taskDTOList);
        assertEquals(2, taskDTOList.size());

        TaskDTO taskDTO1 = taskDTOList.get(0);
        assertEquals(task1.getId(), taskDTO1.getId());
        assertEquals(task1.getTitle(), taskDTO1.getTitle());
        assertEquals(task1.getDescription(), taskDTO1.getDescription());
        assertEquals(task1.getStartDate(), taskDTO1.getStartDate());
        assertEquals(task1.getPriority(), taskDTO1.getPriority());

        TaskDTO taskDTO2 = taskDTOList.get(1);
        assertEquals(task2.getId(), taskDTO2.getId());
        assertEquals(task2.getTitle(), taskDTO2.getTitle());
        assertEquals(task2.getDescription(), taskDTO2.getDescription());
        assertEquals(task2.getStartDate(), taskDTO2.getStartDate());
        assertEquals(task2.getPriority(), taskDTO2.getPriority());
    }

    @Test
    public void testMapToTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1);
        taskDTO.setTitle("Task 1");
        taskDTO.setDescription("Description 1");
        taskDTO.setStartDate("2024-06-14");
        taskDTO.setPriority(1);

        Task task = taskResponseMapper.mapToTask(taskDTO);

        assertNotNull(task);
        assertEquals(taskDTO.getTitle(), task.getTitle());
        assertEquals(taskDTO.getDescription(), task.getDescription());
        assertEquals(taskDTO.getStartDate(), task.getStartDate());
        assertEquals(taskDTO.getPriority(), task.getPriority());
    }
}