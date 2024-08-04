package com.alfonso.tasktest.infraestructure.serviceimpl;

import com.alfonso.tasktest.domain.entity.Task;
import com.alfonso.tasktest.infraestructure.jpa.TaskJpa;
import com.alfonso.tasktest.infraestructure.mapper.TaskJpaMapper;
import com.alfonso.tasktest.infraestructure.repository.TaskJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AllTaskServiceImplTest {

    @Mock
    private TaskJpaRepository taskJpaRepository;

    @Mock
    private TaskJpaMapper mapper;

    @InjectMocks
    private AllTaskServiceImpl allTaskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetListTask() {
        TaskJpa taskEntity1 = new TaskJpa();
        taskEntity1.setId(1L);
        taskEntity1.setTitle("Task 1");
        taskEntity1.setDescription("Description 1");
        taskEntity1.setStartDate(LocalDate.of(2023, 1, 1));
        taskEntity1.setPriority(1);

        TaskJpa taskEntity2 = new TaskJpa();
        taskEntity2.setId(2L);
        taskEntity2.setTitle("Task 2");
        taskEntity2.setDescription("Description 2");
        taskEntity2.setStartDate(LocalDate.of(2023, 1, 1));
        taskEntity2.setPriority(2);

        List<TaskJpa> taskEntities = Arrays.asList(taskEntity1, taskEntity2);

        Task task1 = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2023-01-01")
                .priority(1)
                .build();

        Task task2 = Task.builder()
                .id(2)
                .title("Task 2")
                .description("Description 2")
                .startDate("2023-01-02")
                .priority(2)
                .build();

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskJpaRepository.findAll()).thenReturn(taskEntities);
        when(mapper.toTaskList(taskEntities)).thenReturn(tasks);

        List<Task> result = allTaskService.getListTask();

        assertEquals(tasks.size(), result.size());
        verify(taskJpaRepository, times(1)).findAll();
    }

}