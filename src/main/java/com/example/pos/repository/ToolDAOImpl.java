package com.example.pos.repository;

import com.example.pos.beans.tool.Brand;
import com.example.pos.beans.tool.Tool;
import com.example.pos.beans.tool.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolDAOImpl {
  private static List<Tool> toolList = new ArrayList<>();
  private static List<String> toolWarehouse = new ArrayList<>();

  static {
    toolList.add(new Tool("CHNS", Type.Chainsaw, Brand.Stihl));
    toolList.add(new Tool("LADW", Type.Ladder, Brand.Werner));
    toolList.add(new Tool("JAKD", Type.Jackhammer, Brand.DeWalt));
    toolList.add(new Tool("JAKR", Type.Jackhammer, Brand.Ridgid));

    toolWarehouse.add("CHNS");
    toolWarehouse.add("LADW");
    toolWarehouse.add("JAKD");
    toolWarehouse.add("JAKR");
  }

  public Tool getTool(String toolCode) {
    return toolList.get(this.toolWarehouse.indexOf(toolCode));
  }
}
