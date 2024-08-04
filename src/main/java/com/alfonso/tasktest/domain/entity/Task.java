package com.alfonso.tasktest.domain.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * The type Task.
 */
@Builder
@Data
@ToString
@EqualsAndHashCode
public class Task {

    /**
     * The Id.
     */
    private Integer id;

    /**
     * The Title.
     */
    private String title;

    /**
     * The Description.
     */
    private String description;

    /**
     * The Start date.
     */
    private String startDate;

    /**
     * The Priority.
     */
    private Integer priority;
}
