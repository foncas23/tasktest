package com.alfonso.tasktest.domain.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Data
@ToString
@EqualsAndHashCode
public class Task {

    private Integer id;

    private String title;

    private String description;

    private String startDate;

    private Integer priority;
}
