package com.alfonso.tasktest.application.usecase;

import com.alfonso.tasktest.application.mapper.TaskResponseMapper;
import com.alfonso.tasktest.config.annotation.UseCase;
import com.alfonso.tasktest.domain.iservice.AllTaskService;
import com.napptilus.openapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The type Get all task use case.
 */
@UseCase
@RequiredArgsConstructor
public class GetAllTaskUseCase {

    /**
     * The All task service.
     */
    private final AllTaskService allTaskService;

    /**
     * The Mapper.
     */
    private final TaskResponseMapper mapper;

    /**
     * Execute list.
     *
     * @return the list
     */
    public List<TaskDTO> execute(){
        return this.mapper.maptoListTaskDto(this.allTaskService.getListTask());
    }


}
