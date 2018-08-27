package com.juanbrz.componentexample.service;

import com.juanbrz.componentexample.model.User;

public interface LoginService {

  /**
   * Return the logged user
   * @param username Username
   * @param password Password
   * @return User object
   */
  User login(String username, String password);

}
