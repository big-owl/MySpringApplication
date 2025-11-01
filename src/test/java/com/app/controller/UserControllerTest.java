package com.app.controller;

import com.app.user.UserDto;
import com.app.user.UserList;
import com.app.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {

  private MockMvc mockMvc;
  private UserDto user;
  private UserService userService;

  @BeforeEach
  public void setup() {
    this.user = new UserDto();
    this.userService = Mockito.mock(UserService.class);
    UserController controller = new UserController(userService);
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
    when(userService.getUser(anyLong())).thenReturn(user);

    this.mockMvc.perform(get("/test").param("id", String.valueOf(user.getId())))
        .andExpect(status().isOk())
        .andExpect(view().name("testEndpoints"))
        .andExpect(model().attribute("id", user.getId()))
        .andReturn();
  }

  @Test
  public void testUserViewPage() throws Exception {
    when(userService.getUser(anyLong())).thenReturn(user);

    this.mockMvc.perform(get("/user").param("id", String.valueOf(user.getId())))
        .andExpect(status().isOk())
        .andExpect(view().name("userView"))
        .andExpect(model().attribute("name", user.getName()))
        .andExpect(model().attribute("id", user.getId()))
        .andReturn();
  }

  @Test
  public void testGetUsers() throws Exception {
    UserList userList = new UserList();
    userList.addUser(user);
    when(userService.getAllUsers()).thenReturn(userList);

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

    when(userService.getUser(user.getId())).thenReturn(user);
    result = this.mockMvc.perform(get("/user/" + user.getId() + "/name"))
             .andExpect(status().isOk())
             .andReturn();
    name = result.getResponse().getContentAsString();
    expected = user.getName();
    assertTrue(name.equals(expected));

    //user with id 0 should not exist
    when(userService.getUser(0L)).thenReturn(null);
    result = this.mockMvc.perform(get("/user/0/name"))
             .andExpect(status().isNotFound())
             .andReturn();
    name = result.getResponse().getContentAsString();
    expected = "User not found";
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

  @Test
  public void testSubmitSuccess() throws Exception {
    MvcResult result = this.mockMvc.perform(post("/user/update")
        .param("id","123")
        .param("name", "Glenn")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(view().name("userView"))
        .andReturn();

    // Verify the service was called
    Mockito.verify(userService).saveUser(Mockito.any(UserDto.class));
  }
}
