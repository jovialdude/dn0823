package com.example.pos.beans;

import java.time.LocalDate;

public class RentalDatesDetails {
  LocalDate startDate;
  LocalDate endDate;
  int duration;
  int daysCharged;

  public RentalDatesDetails(){}

  public RentalDatesDetails(LocalDate startDate, LocalDate endDate, int duration, int daysCharged) {
    this.startDate=startDate;
    this.endDate=endDate;
    this.duration=duration;
    this.daysCharged=daysCharged;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getDaysCharged() {
    return daysCharged;
  }

  public void setDaysCharged(int daysCharged) {
    this.daysCharged = daysCharged;
  }

  public String toString() {
    return this.startDate + " "
        + this.endDate + " "
        + this.duration + " "
        + this.daysCharged;
  }
}
