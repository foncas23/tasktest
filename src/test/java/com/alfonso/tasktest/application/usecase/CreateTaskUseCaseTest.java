package com.alfonso.tasktest.application.usecase;

import com.alfonso.tasktest.application.mapper.TaskResponseMapper;
import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.domain.iservice.CreateTaskService;
import com.napptilus.openapi.model.TaskDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateTaskUseCaseTest {

    @InjectMocks
    private CreateTaskUseCase createTaskUseCase;

    @Mock
    private CreateTaskService createTaskService;

    @Mock
    private TaskResponseMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeTest(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1);
        taskDTO.setTitle("Task 1");
        taskDTO.setDescription("Description 1");
        taskDTO.setStartDate("2024-06-14");
        taskDTO.setPriority(1);

        Task task = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        when(mapper.mapToTask(taskDTO)).thenReturn(task);
        createTaskUseCase.execute(taskDTO);
        verify(createTaskService).createTask(task);
    }


}