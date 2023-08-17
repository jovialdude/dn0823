package com.example.pos.services;

import com.example.pos.beans.Charge;
import com.example.pos.beans.RentalDate;
import com.example.pos.beans.tool.Tool;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class AgreementService {
  public AgreementService(){}
  private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

  public void printAgreementToConsole(Tool tool, RentalDate rentalDate, Charge charge) {
//    System.out.println("Start agreement generation process");

    StringBuilder sb = new StringBuilder();
    sb.append("Tool Code: " + tool.getCode() + "\n");
    sb.append("Tool Type: " + tool.getType() + "\n");
    sb.append("Tool Brand: "+ tool.getBrand() + "\n");
    sb.append("Rental Days: " + rentalDate.getDuration() + "\n");
    sb.append("Checkout Date: " + rentalDate.getStartDate() + "\n");
    sb.append("Due Date: " + rentalDate.getEndDate() + "\n");
    sb.append("Daily Rental Charge: " + rentalDate.getRate() + "\n");
    sb.append("Days Charged: " + rentalDate.getDaysCharged() + "\n");
    sb.append("Total Charge: " + charge.getGrossAmount() + "\n");
    sb.append("Discount Percent: " + charge.getDiscountPercentage() + "\n");
    sb.append("Discount Amount: " + charge.getDiscountedAmount() + "\n");
    sb.append("Final Charge: " + charge.getNetAmount() + "\n");

    System.out.println("*****Rental Agreement*****");
    System.out.println(sb.toString());
    System.out.println("*****End*****");
  }

  public void process(Tool tool, RentalDate rentalDate, Charge charge){
    printAgreementToConsole(tool, rentalDate, charge);
  }
}
