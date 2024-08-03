package com.alfonso.tasktest.infraestructure.repository;

import com.alfonso.tasktest.infraestructure.jpa.TaskJpa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Task jpa repository.
 */
public interface TaskJpaRepository extends JpaRepository<TaskJpa, Integer> {}
