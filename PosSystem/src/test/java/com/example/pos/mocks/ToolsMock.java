package com.example.pos.mocks;

import com.example.pos.beans.tool.Tool;

import java.util.HashMap;
import java.util.Map;

public class ToolsMock {
  private static Map<String, Tool> toolSet;

  static {
    toolSet = new HashMap<>();
    toolSet.put("CHNS", new Tool("CHNS", "Chainsaw", "Stihl"));
    toolSet.put("LADW", new Tool("LADW", "Ladder", "Werner"));
    toolSet.put("JAKD", new Tool("JAKD", "Jackhammer", "DeWalt"));
    toolSet.put("JAKR", new Tool("JAKR", "Jackhammer", "Ridgid"));
  }

  public static Tool getTool(String toolCode) {
    return toolSet.getOrDefault(toolCode, new Tool());
  }
}
