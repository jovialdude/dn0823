package com.example.pos.beans.tool;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tool {
  @Id
  @NonNull
  private String code;
  @NonNull
  private String type;
  @NonNull
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
    return this.code + "\n" +
        this.type.toString() + "\n" +
        this.brand.toString() + "\n";
  }
}
