package com.juanbrz.componentexample.service;

import com.juanbrz.componentexample.component.DatabaseComponent;
import com.juanbrz.componentexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

  private static final String NO_PASSWORD = "###";

  /**
   * A component won't change its reference,
   * and it only can be set by constructor
   */
  private final DatabaseComponent databaseComponent;

  /**
   * Inject the component
   * @param databaseComponent
   */
  @Autowired
  public LoginServiceImpl(final DatabaseComponent databaseComponent){
    this.databaseComponent = databaseComponent;
  }

  /**
   * We dont want to return the password
   * @param username
   * @param password
   * @return the logged user without password
   */
  @Override
  public User login(String username, String password) {
    User user = databaseComponent.getUser(username, password);
    // This should be done already in the databaseComponent.
    // Password should not leave the database.
    user.setPassword(NO_PASSWORD);
    return user;
  }
}
