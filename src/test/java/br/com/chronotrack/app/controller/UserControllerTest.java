package br.com.chronotrack.app.controller;


import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
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

  @DisplayName("Should returns 400 if no name is provided")
  @Test
  void shouldReturnsBadRequestIfNoNameIsProvided() throws Exception{
    UserRequestDto dto = new UserRequestDto( null,"any_mail@mail.com", "any_password");
    String jsonBody = objectMapper.writeValueAsString(dto);
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
      .content(jsonBody)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }


}
