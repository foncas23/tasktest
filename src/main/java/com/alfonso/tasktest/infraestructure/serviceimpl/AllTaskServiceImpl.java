package com.alfonso.tasktest.infraestructure.serviceimpl;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.domain.iservice.AllTaskService;
import com.alfonso.tasktest.infraestructure.mapper.TaskJpaMapper;
import com.alfonso.tasktest.infraestructure.repository.TaskJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type All task service.
 */
@Service
@RequiredArgsConstructor
public class AllTaskServiceImpl implements AllTaskService {

    /**
     * The Task jpa repository.
     */
    private final TaskJpaRepository taskJpaRepository;

    @Override
    public List<Task> getListTask() {
        return TaskJpaMapper.INSTANCE.toTaskList(this.taskJpaRepository.findAll());
    }
}
