package com.alfonso.tasktest.domain.iservice;

import com.alfonso.tasktest.domain.entity.Task;

/**
 * The interface Create task service.
 */
public interface CreateTaskService {

    /**
     * Create task.
     *
     * @param task the task
     */
    void createTask(Task task);
}
