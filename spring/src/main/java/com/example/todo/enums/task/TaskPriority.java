package com.example.todo.enums.task;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TaskPriority {

  LOW(0, "低"), MEDIUM(1, "中"), HIGH(2, "高");

  private final int value;
  private final String label;

  TaskPriority(int value, String label) {
    this.value = value;
    this.label = label;
  }

  public static TaskPriority formValue(int value) {
    return Arrays.stream(TaskPriority.values()).filter(priority -> priority.getValue() == value)
        .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
  }

}
