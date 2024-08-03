package com.alfonso.tasktest.infraestructure.mapper;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.infraestructure.jpa.TaskJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskJpaMapper {

    TaskJpaMapper INSTANCE = Mappers.getMapper(TaskJpaMapper.class);

    List<Task> toTaskList(List<TaskJpa> taskJpaList);

    @Mapping(target = "id", ignore = true)
    TaskJpa toTaskJpa(Task task);
}
