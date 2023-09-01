package com.example.pos.services;

import com.example.pos.beans.charge.RentalCharge;
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
  public void testSevenChargedDaysNoDiscount() {
    RentalCharge expected = new RentalCharge(14.0, 0, 14.0, 0);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 7, 0, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testFiveChargedDaysNoDiscount() {
    RentalCharge expected = new RentalCharge(10, 0.0, 10.0
        , 0);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 0, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void test10PercentDiscount() {
    RentalCharge expected = new RentalCharge(10.0, 1.0, 9.0,10);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 10, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void test15PercentDiscount() {
    RentalCharge expected = new RentalCharge(10.0, 2.0, 8.0, 20);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(2, 5, 20, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testOnePercentDiscount() {
    RentalCharge expected = new RentalCharge(100.0, 1.0, 99.0, 1);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(20, 5, 1, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void test99PercentDiscount() {
    RentalCharge expected = new RentalCharge(100.0, 99.0, 1.0, 99);
    RentalCharge actual = new RentalCharge();
    chargeCalculationService.process(20.0, 5, 99, actual);

    Assert.assertEquals(expected.toString(), actual.toString());
  }
}
