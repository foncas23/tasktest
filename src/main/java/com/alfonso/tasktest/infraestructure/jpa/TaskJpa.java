package com.alfonso.tasktest.infraestructure.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * The type Task jpa.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TASK")
public class TaskJpa {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * The Title.
     */
    @NotNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    /**
     * The Description.
     */
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    /**
     * The Start date.
     */
    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    /**
     * The Priority.
     */
    @NotNull
    @Column(name = "PRIORITY", nullable = false)
    private int priority;
}
