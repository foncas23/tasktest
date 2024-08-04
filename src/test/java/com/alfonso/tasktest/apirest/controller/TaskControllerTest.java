package com.alfonso.tasktest.apirest.controller;

import com.alfonso.tasktest.application.usecase.CreateTaskUseCase;
import com.alfonso.tasktest.application.usecase.GetAllTaskUseCase;
import com.napptilus.openapi.model.TaskDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class TaskControllerTest {

    @Mock
    private GetAllTaskUseCase getAllTaskUseCase;

    @Mock
    private CreateTaskUseCase createTaskUseCase;

    @InjectMocks
    private TaskController taskController;

    public TaskControllerTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Nested
    class createTask{
        @Test
        void testCreateTask() {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(1);
            taskDTO.setTitle("Test Task");
            taskDTO.setDescription("This is a test task");
            taskDTO.setStartDate("2024-08-01");
            taskDTO.setPriority(1);

            ResponseEntity<TaskDTO> response = taskController.createTask(taskDTO);

            assertEquals(ResponseEntity.ok().build(), response);
        }
    }

    @Nested
    class getTask{
        @Test
        void testGetTasks() {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(1);
            taskDTO.setTitle("Test Task");
            taskDTO.setDescription("This is a test task");
            taskDTO.setStartDate("2024-08-01");
            taskDTO.setPriority(1);

            List<TaskDTO> taskList = new ArrayList<>();
            taskList.add(taskDTO);
            when(getAllTaskUseCase.execute()).thenReturn(taskList);

            ResponseEntity<List<TaskDTO>> response = taskController.getTasks();

            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }
}