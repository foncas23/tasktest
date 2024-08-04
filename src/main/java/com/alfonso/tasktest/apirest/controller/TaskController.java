package com.alfonso.tasktest.apirest.controller;

import com.alfonso.tasktest.application.usecase.CreateTaskUseCase;
import com.alfonso.tasktest.application.usecase.GetAllTaskUseCase;
import com.alfonso.tasktest.config.handlerexception.ApiErrorResponseBuilder;
import com.napptilus.openapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.napptilus.openapi.api.TaskApi;

import java.util.List;

/**
 * The type Task controller.
 */
@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi{

    /**
     * The Get all task use case.
     */
    private final GetAllTaskUseCase getAllTaskUseCase;

    /**
     * The Create task use case.
     */
    private final CreateTaskUseCase createTaskUseCase;


    /**
     * POST /tasks : Create a new task
     * Creates a new task and stores it in the database.
     *
     * @param taskDTO TaskDto object that needs to be added (required)
     * @return Task created (status code 201)
     * or Request contains incorrect syntax or cannot be processed (status code 400)
     * or Unauthorized (status code 401)
     * or Forbidden (status code 403)
     * or Internal Server Errorabrir s (status code 500)
     */
    @Override
    public ResponseEntity<TaskDTO> createTask(TaskDTO taskDTO) {
        this.createTaskUseCase.execute(taskDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /tasks : Get list of tasks
     * Retrieves a list of tasks.
     *
     * @return A list of tasks (status code 200)
     * or Request contains incorrect syntax or cannot be processed (status code 400)
     * or Unauthorized (status code 401)
     * or Forbidden (status code 403)
     * or Internal Server Error (status code 500)
     * or Service Unavailable (status code 503)
     */
    @Override
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return ResponseEntity.ok(this.getAllTaskUseCase.execute());
    }
}
