package com.juanbrz.componentexample.service;

import com.juanbrz.componentexample.model.User;

public interface LoginService {

  User login(String username, String password);

}
