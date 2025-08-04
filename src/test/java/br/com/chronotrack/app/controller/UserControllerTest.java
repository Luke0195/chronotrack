package br.com.chronotrack.app.controller;


import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @DisplayName("should returns 400 if no name is provided")
  @Test
  void shouldReturnsBadRequestIfNoNameIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto( null,"any_mail@mail.com", "any_password");
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(parseObjectToString(dto))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @DisplayName("should returns 400 if no email is provided")
  @Test
  void shouldReturnsBadRequestIfNoEmailIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto("any_name", null, "any_password");
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(parseObjectToString(dto))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
    );
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @DisplayName("should returns 400 if an invalid email is provided")
  @Test
  void shouldReturnsBadRequestIfAnInvalidEmailIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto("any_name", "any_mail", "any_password");
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(parseObjectToString(dto))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
    );
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @DisplayName("should returns 400 if no password is provided")
  @Test
  void shouldReturnsBadRequestIfNoPasswordIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto("any_name", "any_mail@mail.com", null);
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(parseObjectToString(dto))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
    );
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @DisplayName("should returns 400 if an invalid password is provided")
  @Test
  void shouldReturnsBadRequestIfAnInvalidPasswordIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto("any_name", "any_mail@mail.com", "any_p");
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(parseObjectToString(dto))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
    );
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  private String parseObjectToString(Object object) throws Exception{
    return objectMapper.writeValueAsString(object);
  }


}
