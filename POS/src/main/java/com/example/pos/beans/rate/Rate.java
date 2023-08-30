package com.example.pos.beans.rate;

import org.springframework.stereotype.Component;


@Component
public class Rate {
  private String type;
  private double dailyCharge;
  private boolean weekday;
  private boolean weekend;
  private boolean holiday;

  public Rate() {}

  public Rate(String type, double dailyCharge, boolean weekday, boolean weekend, boolean holiday) {
    this.type = type;
    this.dailyCharge = dailyCharge;
    this.weekday = weekday;
    this.weekend = weekend;
    this.holiday = holiday;
  }

  public String getType() {
    return type;
  }

  public double getDailyCharge() {
    return dailyCharge;
  }

  public boolean getWeekday() { return weekday; }

  public boolean isWeekend() {
    return weekend;
  }

  public boolean isHoliday() {
    return holiday;
  }

  public String toString() {
    return
      this.type + " " +
      this.dailyCharge;
  }
}