package com.example.services;

import com.example.pos.beans.tool.Brand;
import com.example.pos.beans.tool.Tool;
import com.example.pos.beans.tool.Type;

import java.util.ArrayList;
import java.util.List;

public class CheckoutServiceTest {
  private static List<Tool> toolList = new ArrayList<>();


  static {
    toolList.add(new Tool("CHSN", Type.Chainsaw, Brand.Stihl));
    toolList.add(new Tool("LADW", Type.Ladder, Brand.Werner));
    toolList.add(new Tool("JAKD", Type.Jackhammer, Brand.DeWalt));
    toolList.add(new Tool("JAKR", Type.Jackhammer, Brand.Ridgid));
  }

}
