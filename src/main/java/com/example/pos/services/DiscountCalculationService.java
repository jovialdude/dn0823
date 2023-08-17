package com.example.pos.services;

import com.example.pos.beans.Charge;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculationService {
  public Charge process(double dailyRate, int numDays, int discountPercentage) {
//    System.out.println("Start charge calculation process");
    double grossCharge = dailyRate * numDays;
    double amountDiscounted = grossCharge*discountPercentage/100.0;
    double netCharge = grossCharge - amountDiscounted;

//    System.out.println("Finish charge calculation process");
    return new Charge(grossCharge, amountDiscounted, netCharge, dailyRate, discountPercentage);
  }
}
