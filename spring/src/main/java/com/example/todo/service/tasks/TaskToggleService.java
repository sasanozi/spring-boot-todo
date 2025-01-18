package com.example.todo.service.tasks;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.example.todo.dto.response.tasks.TaskBaseResponse;
import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskToggleService {

  private final TaskRepository taskRepository;

  public TaskToggleService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public TaskBaseResponse invoke(Integer id) {

    Task task = this.taskRepository.findById(id).orElseThrow(
      () -> new EntityNotFoundException("Task not found with ID: " + id));

    boolean isCompleted = task.getCompletedAt() != null;
    task.setCompletedAt(isCompleted ? null : LocalDateTime.now());

    Task toggleTask = this.taskRepository.save(task);

    return new TaskBaseResponse(toggleTask);
  }

}
