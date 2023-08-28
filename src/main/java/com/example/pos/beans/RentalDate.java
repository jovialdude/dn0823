package com.example.pos.beans;

import java.time.LocalDate;

public class RentalDate {
  LocalDate startDate;
  LocalDate endDate;
  int duration;
  int daysCharged;

  public RentalDate(){}

  public RentalDate(LocalDate startDate, LocalDate endDate, int duration, int daysCharged) {
    this.startDate=startDate;
    this.endDate=endDate;
    this.duration=duration;
    this.daysCharged=daysCharged;
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

  public String toString() {
    return this.startDate + "/n"
        + this.endDate + "/n"
        + this.duration + "/n"
        + this.daysCharged;
  }
}
