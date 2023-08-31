package com.example.pos.services.interfaces;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.beans.rate.Rate;
import org.springframework.stereotype.Component;

@Component
public interface ChargeCalculation {
  void process(double rate, int totalDays, int chargedDays, int discountRate, RentalCharge rentalCharge);
}
