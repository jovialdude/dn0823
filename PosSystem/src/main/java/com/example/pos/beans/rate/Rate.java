package com.example.pos.beans.rate;

import org.springframework.stereotype.Component;


@Component
public class Rate {
  private String type;
  private double dailyCharge;
  private boolean chargeWeekday;
  private boolean chargeWeekend;
  private boolean chargeHoliday;

  public Rate() {}

  public Rate(String type, double dailyCharge, boolean chargeWeekday, boolean chargeWeekend, boolean chargeHoliday) {
    this.type = type;
    this.dailyCharge = dailyCharge;
    this.chargeWeekday = chargeWeekday;
    this.chargeWeekend = chargeWeekend;
    this.chargeHoliday = chargeHoliday;
  }

  public String getType() {
    return type;
  }

  public double getDailyCharge() {
    return dailyCharge;
  }

  public boolean getChargeWeekday() { return chargeWeekday; }

  public boolean isChargeWeekend() {
    return chargeWeekend;
  }

  public boolean isChargeHoliday() {
    return chargeHoliday;
  }

  public String toString() {
    return
      this.type + " " +
      this.dailyCharge;
  }
}