package com.example.pos.beans.rate;

import org.springframework.stereotype.Component;

public class Rate {
  private String type;
  private double dailyCharge;
  private boolean weekend;
  private boolean holiday;

  public Rate() {}

  public Rate(String type, double dailyCharge, boolean weekend, boolean holiday) {
    this.type = type;
    this.dailyCharge = dailyCharge;
    this.weekend = weekend;
    this.holiday = holiday;
  }

  public String getBrand() {
    return type;
  }

  public double getDailyCharge() {
    return dailyCharge;
  }

  public boolean isWeekend() {
    return weekend;
  }

  public boolean isHoliday() {
    return holiday;
  }

}
