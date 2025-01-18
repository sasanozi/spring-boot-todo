package com.example.todo.entity;

import java.time.LocalDateTime;
import com.example.todo.enums.task.TaskPriority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tasks")
@EqualsAndHashCode(callSuper = false)
public class Task extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;

  @Column(nullable = false, length = 255)
  private String name;

  @Column(nullable = false, columnDefinition = "SMALLINT")
  @Enumerated(EnumType.ORDINAL)
  private TaskPriority priority;

  @Column(columnDefinition = "TEXT")
  private String memo;

  @Column(name = "deadline_at")
  private LocalDateTime deadlineAt;

  @Column(name = "completed_at")
  private LocalDateTime completedAt;

  public boolean isCompleted() {
    return this.completedAt != null;
  }

  public void toggleCompleted() {
    this.setCompletedAt(this.isCompleted() ? null : LocalDateTime.now());
  }
}
