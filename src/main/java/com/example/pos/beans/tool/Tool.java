package com.example.pos.beans.tool;

import org.springframework.stereotype.Component;

public class Tool {
  private String code;
  private Type type;
  private Brand brand;

  public Tool(){}

  public Tool(String code, Type type, Brand brand) {
    this.code = code;
    this.brand = brand;
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public Brand getBrand() {
    return brand;
  }

  public Type getType() {
    return type;
  }

  public String toString() {
    return this.code + this.type.toString() + this.brand.toString();
  }
}
