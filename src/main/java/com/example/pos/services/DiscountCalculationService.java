package com.example.pos.services;

import com.example.pos.beans.Charge;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculationService {
  public Charge process(double dailyRate, int numDays, int discountPercentage) {
    double grossCharge = dailyRate * numDays;
    double amountDiscounted = grossCharge*discountPercentage/100.0;
    double netCharge = grossCharge - amountDiscounted;

    return new Charge(grossCharge, amountDiscounted, netCharge, dailyRate, discountPercentage);
  }
}
