package com.example.todo.service.tasks;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.todo.dto.request.tasks.TaskSearchRequest;
import com.example.todo.dto.response.tasks.TaskBaseResponse;
import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.repository.specification.TaskSpecification;

@Service
public class TaskSearchService {

  private final TaskRepository taskRepository;

  public TaskSearchService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<TaskBaseResponse> invoke(TaskSearchRequest request) {
    TaskSpecification taskSpec = new TaskSpecification();
    Specification<Task> spec =
        Specification.where(taskSpec.projectIdEquals(request.getProjectId()));

    Sort sort = Sort.by(Sort.Order.desc("completedAt"), Sort.Order.asc("deadlineAt"),
        Sort.Order.desc("id"));

    List<Task> tasks = this.taskRepository.findAll(spec, sort);

    return tasks.stream().map(task -> new TaskBaseResponse(task)).collect(Collectors.toList());
  }
}
