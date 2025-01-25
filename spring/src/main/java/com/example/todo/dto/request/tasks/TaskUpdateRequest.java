package com.example.todo.dto.request.tasks;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import com.example.todo.enums.task.TaskPriority;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TaskUpdateRequest {

  @NotNull
  @Positive
  private final Integer id;

  @NotEmpty
  private final String name;

  private final Integer projectId;

  @NotNull
  private final TaskPriority priority;

  private final String memo;

  private final ZonedDateTime deadlineAt;

  private final ZonedDateTime completedAt;

  public LocalDateTime getDeadlineAt() {
    return this.deadlineAt != null ? this.deadlineAt.toLocalDateTime() : null;
  }

  public LocalDateTime getCompleted() {
    return this.completedAt != null ? this.completedAt.toLocalDateTime() : null;
  }

}
