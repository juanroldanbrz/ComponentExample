package com.juanbrz.componentexample.service;

import com.juanbrz.componentexample.component.DatabaseComponent;
import com.juanbrz.componentexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

  private static final String NO_PASSWORD = "###";

  private final DatabaseComponent databaseComponent;

  @Autowired
  public LoginServiceImpl(final DatabaseComponent databaseComponent){
    this.databaseComponent = databaseComponent;
  }

  @Override
  public User login(String username, String password) {
    User user = databaseComponent.getUser(username, password);
    user.setPassword(NO_PASSWORD);
    return user;
  }
}
