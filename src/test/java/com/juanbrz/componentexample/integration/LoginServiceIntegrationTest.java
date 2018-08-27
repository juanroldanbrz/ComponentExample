package com.juanbrz.componentexample.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.juanbrz.componentexample.exception.NotAuthorizedException;
import com.juanbrz.componentexample.model.User;
import com.juanbrz.componentexample.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceIntegrationTest {

  /**
   * This is the easiest option to use autowired in test.
   * If we try constructor injection we will get:
   *
   * java.lang.Exception: Test class should have exactly
   * one public zero-argument constructor
   */
  @Autowired
  private LoginService loginService;

  @Test
  public void testLogin(){
    //Arrange
    String username = "juan12";
    String password = "1234";

    User toSave = new User();
    toSave.setEmail("juan.roldan.brz@gmail.com");
    toSave.setPassword(password);
    toSave.setUserName(username);

    //Act
    loginService.register(toSave);
    User savedUser = loginService.login(username, password);

    //Assert
    assertNotNull(savedUser);
    assertEquals("The username is the same", username, savedUser.getUserName());
    assertNotEquals("The password is not included", password, savedUser.getPassword());
    assertFalse("The userId is not empty", StringUtils.isEmpty(savedUser.getId()));
  }

  @Test(expected = NotAuthorizedException.class)
  public void testBadLogin(){
    //Act && Assert
    loginService.login("aaa","aaa");
  }
}
