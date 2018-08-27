package com.juanbrz.componentexample.exception;

public class NotAuthorizedException extends RuntimeException {

  public NotAuthorizedException(String msg){
    super(msg);
  }

  public NotAuthorizedException(String msg, Throwable throwable){
    super(msg, throwable);
  }

}
