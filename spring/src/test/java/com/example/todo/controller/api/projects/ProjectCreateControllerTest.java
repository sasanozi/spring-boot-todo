package com.example.todo.controller.api.projects;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.todo.dto.request.projects.ProjectCreateRequest;
import com.example.todo.entity.Project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProjectCreateController.class)
class ProjectCreateControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProjectCreateService projectCreateService;

  @Test
  void 作成されたプロジェクトが返されること() throws Exception {

    Project mockProject = new Project();
    mockProject.setId(1);
    mockProject.setName("name");
    mockProject.setSummary("this is a new project");

    Mockito.when(this.projectCreateService.invoke(Mockito.any(ProjectCreateRequest.class)))
        .thenReturn(mockProject);

    // リクエストボディを作成
    String expectRequestBody = """
        {
            "name": "New Project",
            "summary": "This is a new project"
        }
        """;

    this.mockMvc
        .perform(post("/api/projects").contentType(MediaType.APPLICATION_JSON)
            .content(expectRequestBody))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.name").value("name"))
        .andExpect(jsonPath("$.summary").value("this is a new project"));


  }

}
