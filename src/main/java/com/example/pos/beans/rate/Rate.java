package com.example.pos.beans.rate;

import org.springframework.stereotype.Component;

@Component
public class Rate {
  String type;
  double dailyCharge;
  boolean weekend;
  boolean holiday;

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

  public void setBrand(String brand) {
    this.type = brand;
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
