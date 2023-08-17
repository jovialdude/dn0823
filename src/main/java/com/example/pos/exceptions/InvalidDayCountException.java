package com.example.pos.exceptions;

public class InvalidDayCountException extends RuntimeException {
  public InvalidDayCountException(){super();}
  public InvalidDayCountException(String message, Throwable e) {
    super(message, e);
  }
}
