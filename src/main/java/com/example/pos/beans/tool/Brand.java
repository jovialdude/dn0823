package com.example.pos.beans.tool;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public enum Brand {
  Stihl(1, "S"),
  Werner(2, "W"),
  DeWalt(3, "D"),
  Ridgid(4, "R");

  private final int val;
  private final String initials;
  private static Map<Integer, Brand> valueMap = new HashMap<>();
  private static Map<Integer, String> initialsMap = new HashMap<>();

  static {
    for (Brand b: Brand.values()) {
      valueMap.put(b.val, b);
      initialsMap.put(b.val, b.initials);
    }
  }

  private Brand(int i, String s){
    this.val = i;
    this.initials=s;
  }

  public static Brand getBrand(int i) {
    return valueMap.get(i);
  }

  public static String getInitials(int i) {
    return initialsMap.get(i);
  }
}
