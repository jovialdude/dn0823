package com.example.pos.services;

import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.exceptions.InvalidChargedDaysException;
import com.example.pos.services.interfaces.ChargeCalculation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChargeCalculationServiceTest {
  private ChargeCalculation chargeCalculationService;

  @Before
  public void init() {
    chargeCalculationService=new ChargeCalculationService();
  }

  @Test
  public void testSevenTotalFiveChargedDays() {
    RentalCharge expected = new RentalCharge(14.0, 4, 10.0, 2.0, 0);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 7, 5, 0, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testFiveTotalFiveChargedDays() {
    RentalCharge expected = new RentalCharge(10, 0, 10, 2.0, 0);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 5, 0, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test(expected = InvalidChargedDaysException.class)
  public void testSevenTotalToNineChargedDays() {
    chargeCalculationService.process(2, 7, 9, 0, new RentalCharge());
  }

  @Test
  public void test10DiscountPercentage() {
    RentalCharge expected = new RentalCharge(10, 1, 9, 2.0, 10);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 5, 10, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void test15DiscountPercentage() {
    RentalCharge expected = new RentalCharge(10, 2, 8, 2.0, 20);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 5, 20, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }
}
