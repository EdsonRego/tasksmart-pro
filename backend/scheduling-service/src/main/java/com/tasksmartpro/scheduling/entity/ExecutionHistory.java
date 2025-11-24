package com.tasksmartpro.scheduling.entity;

import com.tasksmartpro.scheduling.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "execution_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExecutionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long scheduledTaskId;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime executedAt;

    private String message;
}
