package com.alfonso.tasktest.infraestructure.serviceimpl;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.domain.iservice.CreateTaskService;
import com.alfonso.tasktest.infraestructure.mapper.TaskJpaMapper;
import com.alfonso.tasktest.infraestructure.repository.TaskJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Create task service.
 */
@Service
@RequiredArgsConstructor
public class CreateTaskServiceImpl implements CreateTaskService {

    /**
     * The Task jpa repository.
     */
    private final TaskJpaRepository taskJpaRepository;

    @Override
    public void createTask(Task task) {
        try {
            this.taskJpaRepository.save(TaskJpaMapper.INSTANCE.toTaskJpa(task));
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar en la BBDD");
        }
    }
}
