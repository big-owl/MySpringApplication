package com.app.controller;

import com.app.user.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {

  private MockMvc mockMvc;
  private UserDto user;

  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    this.user = new UserDto();
  }

  @Test
  public void testHomePage() throws Exception {
    this.mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"))
        //.andDo(MockMvcResultHandlers.print())
        .andReturn();
  }

  @Test
  public void testEndpointsPage() throws Exception {
    this.mockMvc.perform(get("/test"))
        .andExpect(status().isOk())
        .andExpect(view().name("testEndpoints"))
        .andExpect(model().attribute("id", user.getId()))
        .andReturn();
  }

  @Test
  public void testUserViewPage() throws Exception {
    this.mockMvc.perform(get("/user"))
        .andExpect(status().isOk())
        .andExpect(view().name("userView"))
        .andExpect(model().attribute("name", user.getName()))
        .andExpect(model().attribute("id", user.getId()))
        .andReturn();
  }

  @Test
  public void testGetUsers() throws Exception {
    MvcResult result = this.mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andReturn();
    String content = result.getResponse().getContentAsString();
    String expected = "{\"users\":[{\"id\":" + user.getId() + ",\"name\":\"" + user.getName() + "\"}]}";
    assertTrue(content.equals(expected));
  }

  @Test
  public void testGetById() throws Exception {
    MvcResult result;
    String name;
    String expected;

    result = this.mockMvc.perform(get("/user/" + user.getId() + "/name"))
        .andExpect(status().isOk())
        .andReturn();
    name = result.getResponse().getContentAsString();
    expected = user.getName();
    assertTrue(name.equals(expected));

    //user with id 0 should not exist
    result = this.mockMvc.perform(get("/user/0/name"))
        .andExpect(status().isOk())
        .andReturn();
    name = result.getResponse().getContentAsString();
    expected = "unknown";
    assertTrue(name.equals(expected));
  }

  @Test
  public void testSubmit() throws Exception {
    MvcResult result;

    // test for invalid id value
    result = this.mockMvc.perform(post("/user/update")
        .param("id","abc")
        .param("name", "Glenn")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();

    Map<String, Object> model = new HashMap<String, Object>();
    model = result.getModelAndView().getModel();
    String errorMessage = model.get("errorMessage").toString();
    assertTrue(errorMessage.equals("invalid input"));
  }
}
