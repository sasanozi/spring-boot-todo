package com.example.todo.dto.request.projects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

class ProjectCreateRequestTest {

  private jakarta.validation.Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    this.validator = factory.getValidator();
  }

  @Test
  void 有効なリクエストであること(){
    ProjectCreateRequest request = new ProjectCreateRequest("name","summary");

    Set<ConstraintViolation<ProjectCreateRequest>> validations = this.validator.validate(request);

    assertTrue(validations.isEmpty());
    assertEquals("name", request.getName());
    assertEquals("summary", request.getSummary());
  }

  @Test
  void nameが空の場合にエラーになること(){
      // テスト対象のインスタンスを作成
      ProjectCreateRequest request = new ProjectCreateRequest("", "summary");

      // バリデーションを実行し、違反が無いことを確認
      Set<ConstraintViolation<ProjectCreateRequest>> validations = this.validator.validate(request);

      assertEquals(1, validations.size());

      assertEquals("", request.getName());
      assertEquals("summary", request.getSummary());
  }

  @Test
  void 概要が空の場合でも有効なリクエストであること(){
    ProjectCreateRequest request = new ProjectCreateRequest("name","");

    Set<ConstraintViolation<ProjectCreateRequest>> validations = this.validator.validate(request);

    assertTrue(validations.isEmpty());
    assertEquals("name", request.getName());
    assertEquals("", request.getSummary());
  }
}
