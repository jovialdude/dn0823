package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.rate.Rate;
import com.example.pos.services.interfaces.DateCalculation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

public class DateGenerationServiceTest {
  DateCalculation dateCalculation;

  @Before
  public void init() {
    dateCalculation = new DateCalculationService();
  }

  @Test
  public void testWeekendNoCharge(){
    Rate rate = new Rate("", 2, true, false, true);
    dateCalculation.process("09/24/23", 5, rate, new RentalDatesDetails());
  }

  @Test
  public void testLaborDayNoCharge() {
    Rate rate = new Rate("", 2, true, true, false);
    dateCalculation.process("09/31/23", 6, rate, new RentalDatesDetails());
  }

  @Test
  public void testJulyFourthNoCharge(){

  }

  @Test
  public void testHolidayFirstDay() {

  }

  @Test
  public void testHolidayLastDay() {

  }

  @Test
  public void testWeekendAndJulyFourthNoCharge() {

  }

  @Test
  public void testWeekendAndLaborDayNoCharge() {

  }
}
