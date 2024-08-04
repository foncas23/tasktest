package com.alfonso.tasktest.infraestructure.mapper;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.infraestructure.jpa.TaskJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Task jpa mapper.
 */
@Mapper(componentModel = "spring")
public interface TaskJpaMapper {

    /**
     * The constant INSTANCE.
     */
    TaskJpaMapper INSTANCE = Mappers.getMapper(TaskJpaMapper.class);

    /**
     * To task list list.
     *
     * @param taskJpaList the task jpa list
     * @return the list
     */
    List<Task> toTaskList(List<TaskJpa> taskJpaList);

    /**
     * To task jpa task jpa.
     *
     * @param task the task
     * @return the task jpa
     */
    @Mapping(target = "id", ignore = true)
    TaskJpa toTaskJpa(Task task);
}
