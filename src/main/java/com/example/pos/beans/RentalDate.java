package com.example.pos.beans;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class RentalDate {
  LocalDate startDate;
  LocalDate endDate;
  int duration;
  int daysCharged;
  double rate;

  public RentalDate(){}

  public RentalDate(LocalDate startDate, LocalDate endDate, int duration, int daysCharged, double rate) {
    this.startDate=startDate;
    this.endDate=endDate;
    this.duration=duration;
    this.daysCharged=daysCharged;
    this.rate = rate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public int getDuration() {
    return duration;
  }

  public int getDaysCharged() {
    return daysCharged;
  }

  public double getRate() {
    return this.rate;
  }

  public String toString() {
    return this.startDate + "/n"
        + this.endDate + "/n"
        + this.duration + "/n"
        + this.daysCharged + "/n";
  }
}
