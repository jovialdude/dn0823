package com.example.pos.services;

import com.example.pos.beans.RentalDate;
import com.example.pos.beans.tool.Brand;
import com.example.pos.beans.tool.Tool;
import com.example.pos.beans.tool.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckoutService {
  @Autowired
  DateService dateService;

  private static List<Tool> toolList = new ArrayList<>();
  private static List<String> toolCode = new ArrayList<>();


  static {
    toolList.add(new Tool("CHSN", Type.Chainsaw, Brand.Stihl));
    toolList.add(new Tool("LADW", Type.Ladder, Brand.Werner));
    toolList.add(new Tool("JAKD", Type.Jackhammer, Brand.DeWalt));
    toolList.add(new Tool("JAKR", Type.Jackhammer, Brand.Ridgid));

    toolCode.add("CHSN");
    toolCode.add("LADW");
    toolCode.add("JAKD");
    toolCode.add("JAKR");
  }

  public RentalDate processDate(String startDate, int days, Type type) throws ParseException {
    return dateService.calculate(startDate, days, type);
   }

//  public void

  public void process (String toolCode, String rentalStart, int rentalDays) throws ParseException {
//    Tool type = toolSelection();
    Tool tool = toolList.get(toolCode.indexOf(toolCode));
    RentalDate rentalDate = processDate(rentalStart, rentalDays, tool.getType());
  }
}
