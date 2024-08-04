package com.alfonso.tasktest.application.usecase;

import com.alfonso.tasktest.application.mapper.TaskResponseMapper;
import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.domain.iservice.AllTaskService;
import com.napptilus.openapi.model.TaskDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetAllTaskUseCaseTest {

    @Mock
    private AllTaskService allTaskService;

    @Mock
    private TaskResponseMapper mapper;

    @InjectMocks
    private GetAllTaskUseCase getAllTaskUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        Task task1 = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2023-01-01")
                .priority(1)
                .build();

        Task task2 = Task.builder()
                .id(2)
                .title("Task 2")
                .description("Description 2")
                .startDate("2023-01-02")
                .priority(2)
                .build();

        List<Task> tasks = Arrays.asList(task1, task2);

        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setId(1);
        taskDTO1.setTitle("Task 1");
        taskDTO1.setDescription("Description 1");
        taskDTO1.setStartDate("2023-01-01");
        taskDTO1.setPriority(1);

        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setId(2);
        taskDTO2.setTitle("Task 2");
        taskDTO2.setDescription("Description 2");
        taskDTO2.setStartDate("2023-01-02");
        taskDTO2.setPriority(2);

        List<TaskDTO> taskDTOs = Arrays.asList(taskDTO1, taskDTO2);

        when(allTaskService.getListTask()).thenReturn(tasks);
        when(mapper.maptoListTaskDto(tasks)).thenReturn(taskDTOs);

        List<TaskDTO> result = getAllTaskUseCase.execute();

        assertEquals(taskDTOs, result);
        verify(allTaskService, times(1)).getListTask();
        verify(mapper, times(1)).maptoListTaskDto(tasks);
    }

}