package com.example.pos.services;

import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.services.interfaces.ChargeCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ChargeCalculationService implements ChargeCalculation {
  private final Logger log = LoggerFactory.getLogger(ChargeCalculationService.class);
  @Override
  public void process(double rate, int chargedDays, int discountRate, RentalCharge rentalCharge) {
    log.info("Start Charge Calculation Process");
    double grossCharge = rate*chargedDays;
    double discountAmount = (discountRate * grossCharge)/100.0;
    double netCharge = grossCharge-discountAmount;

    rentalCharge.setGrossCharge(grossCharge);
    rentalCharge.setNetCharge(netCharge);
    rentalCharge.setDiscountPercentage(discountRate);
    rentalCharge.setDiscountedAmount(discountAmount);
    log.info("Finish Charge Calculation Process");
  }
}
