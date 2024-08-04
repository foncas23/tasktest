package com.alfonso.tasktest.infraestructure.serviceimpl;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.infraestructure.mapper.TaskJpaMapper;
import com.alfonso.tasktest.infraestructure.repository.TaskJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateTaskServiceImplTest {

    @Mock
    private TaskJpaRepository taskJpaRepository;

    @InjectMocks
    private CreateTaskServiceImpl createTaskServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTaskSuccess() {
        Task task = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        when(taskJpaRepository.save(any())).thenReturn(TaskJpaMapper.INSTANCE.toTaskJpa(task));

        createTaskServiceImpl.createTask(task);
        verify(taskJpaRepository, times(1)).save(any());
    }

    @Test
    public void testCreateTaskThrowsRuntimeException() {
        Task task = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        doThrow(new RuntimeException("Error al insertar en la BBDD")).when(taskJpaRepository).save(any());

        assertThrows(RuntimeException.class, () -> createTaskServiceImpl.createTask(task));
        verify(taskJpaRepository, times(1)).save(any());
    }

}