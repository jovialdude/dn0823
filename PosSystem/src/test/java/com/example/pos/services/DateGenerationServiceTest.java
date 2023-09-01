package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.rate.Rate;
import com.example.pos.services.interfaces.DateCalculation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerationServiceTest {
  DateCalculation dateCalculation;
  DateTimeFormatter dtf;

  @Before
  public void init() {
    dateCalculation = new DateCalculationService();
    dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
  }

  @Test
  public void testWeekendNoCharge() {
    Rate rate = new Rate("Test", 2, true, false, true);
    RentalDatesDetails expected =
        new RentalDatesDetails(
            LocalDate.parse("08/24/23", dtf),
            LocalDate.parse("08/29/23", dtf),
            5, 3, rate);
    RentalDatesDetails actual = new RentalDatesDetails();
    dateCalculation.process("08/24/23",
        5, rate, actual);
    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testLaborDayNoCharge() {
    Rate rate = new Rate("Test", 2, true, true, false);
    RentalDatesDetails expected =
        new RentalDatesDetails(
            LocalDate.parse("09/03/23", dtf),
            LocalDate.parse("09/07/23", dtf),
            4, 3, rate
        );
    RentalDatesDetails actual = new RentalDatesDetails();
    dateCalculation.process("09/03/23",
        4, rate, actual);
    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testJulyFourthNoCharge() {
    Rate rate = new Rate("Test", 2, true, true, false);
    RentalDatesDetails expected =
        new RentalDatesDetails(
            LocalDate.parse("07/01/23", dtf),
            LocalDate.parse("07/06/23", dtf),
            5, 4, rate
        );
    RentalDatesDetails actual = new RentalDatesDetails();
    dateCalculation.process("07/01/23",
        5, rate, actual);
    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testJulyFourthAndWeekendNoCharge() {
    Rate rate = new Rate("Test", 2, true, false, false);
    RentalDatesDetails expected =
        new RentalDatesDetails(
            LocalDate.parse("07/01/23", dtf),
            LocalDate.parse("07/01/23", dtf).plusDays(7),
            7, 4, rate
        );
    RentalDatesDetails actual = new RentalDatesDetails();
    dateCalculation.process("07/01/23",
        7, rate, actual);
    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testLaborDayAndWeekendNoCharge() {
    Rate rate = new Rate("Test", 2, true, false, false);
    RentalDatesDetails expected =
        new RentalDatesDetails(
            LocalDate.parse("08/31/23", dtf),
            LocalDate.parse("08/31/23", dtf).plusDays(7),
            7, 4, rate
        );
    RentalDatesDetails actual = new RentalDatesDetails();
    dateCalculation.process("08/31/23",
        7, rate, actual);
    Assert.assertEquals(expected.toString(), actual.toString());
  }
}
