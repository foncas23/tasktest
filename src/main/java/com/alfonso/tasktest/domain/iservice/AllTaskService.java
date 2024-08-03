package com.alfonso.tasktest.domain.iservice;

import com.alfonso.tasktest.domain.entity.Task;

import java.util.List;

/**
 * The interface All task service.
 */
public interface AllTaskService {

    /**
     * Gets list task.
     *
     * @return the list task
     */
    List<Task> getListTask();
}
