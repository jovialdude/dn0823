package com.example.pos.beans;

import com.example.pos.beans.rate.Rate;

import java.time.LocalDate;

public class RentalDatesDetails {
  String startDate;
  String endDate;
  int duration;
  int daysCharged;
  Rate rate;

  public RentalDatesDetails(){}

  public RentalDatesDetails(String startDate, String endDate, int duration, int daysCharged, Rate rate) {
    this.startDate=startDate;
    this.endDate=endDate;
    this.duration=duration;
    this.daysCharged=daysCharged;
    this.rate=rate;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
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

  public Rate getRate() {
    return rate;
  }

  public void setRate(Rate rate) {
    this.rate = rate;
  }

  public String toString() {
    return this.startDate.toString() + " "
        + this.endDate.toString() + " "
        + this.duration + " "
        + this.daysCharged + " "
        + this.rate.toString();
  }
}
