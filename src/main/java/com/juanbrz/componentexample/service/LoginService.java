package com.juanbrz.componentexample.service;

import com.juanbrz.componentexample.component.DatabaseComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final DatabaseComponent databaseComponent;

  @Autowired
  public LoginService(final DatabaseComponent databaseComponent){
    this.databaseComponent = databaseComponent;
  }

}
