package com.example.api.bean;

import org.springframework.stereotype.Component;

@Component
public class Tool {
  private String code;
  private String type;
  private String brand;

  public Tool(){}

  public Tool(String code, String type, String brand) {
    this.code = code;
    this.brand = brand;
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public String toString() {
    return this.code + " " +
        this.type.toString() + " " +
        this.brand.toString();
  }
}
