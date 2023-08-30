package com.example.pos.beans.tool;

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

  public boolean equals(Object obj2) {
    if (!(obj2 instanceof Tool)) return false;
    else {
      return ((Tool) obj2).code==this.code
          && ((Tool) obj2).type==this.type
          && ((Tool) obj2).brand==this.brand;
    }
  }
}
