package com.example.todo.controller.api.tasks;

import com.example.todo.dto.response.tasks.TaskBaseResponse;
import com.example.todo.service.tasks.TaskUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskUpdateController {

  private final TaskUpdateService taskUpdateService;

  public TaskUpdateController(TaskUpdateService taskUpdateService) {
    this.taskUpdateService = taskUpdateService;
  }

  public ResponseEntity<TaskBaseResponse> invoke(){

  }
}
