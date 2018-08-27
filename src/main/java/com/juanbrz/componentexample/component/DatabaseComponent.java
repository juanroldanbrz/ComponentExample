package com.juanbrz.componentexample.component;

import com.juanbrz.componentexample.model.User;

public interface DatabaseComponent {

  /**
   * Returns the userId or throws NotAuthorizedException
   */
  User getUser(String username, String password);

  /**
   * Stores a new user
   * @param user
   * @return user with new id
   */
  User save(User user);

}
