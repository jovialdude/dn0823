package com.example.pos.beans;

import org.apache.tomcat.jni.Local;

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
}
