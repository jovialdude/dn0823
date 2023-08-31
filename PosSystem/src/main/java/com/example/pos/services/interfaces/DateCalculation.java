package com.example.pos.services.interfaces;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.rate.Rate;
import org.springframework.stereotype.Component;

@Component
public interface DateCalculation {
  void process(String startDateString, int numDays, Rate rate, RentalDatesDetails rentalDatesDetails);
}
