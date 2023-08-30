package com.example.pos.exceptions;

public class InvalidDiscountPercentageException extends RuntimeException {
  public InvalidDiscountPercentageException(){super();}
  public InvalidDiscountPercentageException(String message, Throwable e) {
    super(message, e);
  }
}
