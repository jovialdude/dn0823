package com.example.pos.rates;

import org.springframework.stereotype.Component;

@Component
public class Rate {
  double dailyCharge;
//  boolean weekDay;
  boolean weekend;
  boolean holiday;

  public Rate(double dailyCharge, boolean weekend, boolean holiday) {
    this.dailyCharge = dailyCharge;
    this.weekend = weekend;
    this.holiday = holiday;
  }

  public double getDailyCharge() {
    return dailyCharge;
  }

  public void setDailyCharge(double dailyCharge) {
    this.dailyCharge = dailyCharge;
  }

  public boolean isWeekend() {
    return weekend;
  }

  public void setWeekend(boolean weekend) {
    this.weekend = weekend;
  }

  public boolean isHoliday() {
    return holiday;
  }

  public void setHoliday(boolean holiday) {
    this.holiday = holiday;
  }
}
