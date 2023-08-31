package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.beans.rate.Rate;
import com.example.pos.services.interfaces.ChargeCalculation;

public class ChargeCalculationService implements ChargeCalculation {
  @Override
  public void process(double rate, int totalDays, int chargedDays, int discountRate, RentalCharge rentalCharge) {

  }
}
