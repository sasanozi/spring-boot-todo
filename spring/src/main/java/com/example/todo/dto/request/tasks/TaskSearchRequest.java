package com.example.todo.dto.request.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TaskSearchRequest {

  private final Integer projectId;
}