package com.example.todo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.todo.entity.Task;


public class TaskSpecification {

  public Specification<Task> projectIdIsNull() {

    return (root, query, builder) -> builder.isNull(root.get("project"));
  }


  public Specification<Task> projectIdEquals(Integer projectId) {

    if (projectId == null) {
      return projectIdIsNull();
    }
    return (root, query, builder) -> builder.equal(root.get("project").get("id"), projectId);
  }
}
