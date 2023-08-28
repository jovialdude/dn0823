package com.example.pos.beans.rate;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rate {
  @Id
  @NonNull
  private String type;
  @NonNull
  private double dailyCharge;
  @NonNull
  private boolean weekend;
  @NonNull
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
