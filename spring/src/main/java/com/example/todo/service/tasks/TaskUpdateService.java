package com.example.todo.service.tasks;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.example.todo.dto.request.tasks.TaskUpdateRequest;
import com.example.todo.dto.response.tasks.TaskBaseResponse;
import com.example.todo.entity.Project;
import com.example.todo.entity.Task;
import com.example.todo.repository.ProjectRepository;
import com.example.todo.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskUpdateService {

  private final TaskRepository taskRepository;
  private final ProjectRepository projectRepository;

  public TaskUpdateService(TaskRepository taskRepository, ProjectRepository projectRepository) {
    this.taskRepository = taskRepository;
    this.projectRepository = projectRepository;
  }

  public TaskBaseResponse invoke(TaskUpdateRequest request) {

    Task task = this.taskRepository.findById(request.getId()).orElseThrow(
       () -> new EntityNotFoundException("Task not found with id: " + request.getId())
    );

    if (request.getProjectId() != null) {
      Project project = this.projectRepository.findById(request.getProjectId()).orElseThrow(
        () -> new EntityNotFoundException("Project not found with id: " + request.getProjectId())
      );
      task.setProject(project);
    } else {
      task.setProject(null);
    }

    BeanUtils.copyProperties(request, task,"id");

    Task updatedTask = this.taskRepository.save(task);

    return new TaskBaseResponse(updatedTask);
  }
}
