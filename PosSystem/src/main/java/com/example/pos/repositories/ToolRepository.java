package com.example.pos.repositories;

import com.example.pos.beans.tool.Tool;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ToolRepository {
  private Map<String, Tool> toolSet;

  {
    this.toolSet = new HashMap<>();
    this.toolSet.put("CHNS", new Tool("CHNS", "Chainsaw", "Stihl"));
    this.toolSet.put("LADW", new Tool("LADW", "Ladder", "Werner"));
    this.toolSet.put("JAKD", new Tool("JAKD", "Jackhammer", "DeWalt"));
    this.toolSet.put("JAKR", new Tool("JAKR", "Jackhammer", "Ridgid"));
  }

  public Tool getTool(String id) {
    return this.toolSet.get(id);
  }
}
