package com.alfonso.tasktest.application.usecase;

import com.alfonso.tasktest.application.mapper.TaskResponseMapper;
import com.alfonso.tasktest.config.annotation.UseCase;
import com.alfonso.tasktest.domain.iservice.CreateTaskService;
import com.napptilus.openapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;

/**
 * The type Create task use case.
 */
@UseCase
@RequiredArgsConstructor
public class CreateTaskUseCase {

    /**
     * The Create task service.
     */
    private final CreateTaskService createTaskService;

    /**
     * The Mapper.
     */
    private final TaskResponseMapper mapper;

    /**
     * Execute.
     *
     * @param taskDTO the task dto
     */
    public void execute(TaskDTO taskDTO){
        this.createTaskService.createTask(this.mapper.mapToTask(taskDTO));
    }
}
