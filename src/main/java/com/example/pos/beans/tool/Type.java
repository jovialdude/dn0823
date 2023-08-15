package com.example.pos.beans.tool;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public enum Type {
  Chainsaw(1, "CHN"),
  Ladder(2, "LAD"),
  Jackhammer(3, "JAK");

  private final int val;
  private final String initials;
  private static Map<Integer, String> initialsMap = new HashMap<>();
  private static Map<Integer, Type> valueMap = new HashMap<>();

  static {
    for (Type t: Type.values()) {
      valueMap.put(t.val, t);
      initialsMap.put(t.val, t.initials);
    }

  }

  private Type(int i, String s){
    this.val=i;
    this.initials=s;
  }

  public static Type getType(int i) {
    return valueMap.get(i);
  }

  public static String getInitials(int i) {
    return initialsMap.get(i);
  }
}
