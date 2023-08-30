package com.example.pos.beans.agreement;

import org.springframework.stereotype.Component;

@Component
public class Agreement {
  private String code;
  private String startDate;
  private int numRentalDays;

  public Agreement() {}

  public Agreement(String code, String startDate, int numRentalDays) {
    this.code=code;
    this.startDate=startDate;
    this.numRentalDays=numRentalDays;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String days) {
    this.startDate = startDate;
  }

  public int getNumRentalDays() {
    return numRentalDays;
  }

  public void setNumRentalDays(int numRentalDays) {
    this.numRentalDays = numRentalDays;
  }

  public String toString() {
    return this.code + " "
        + this.startDate + " "
        + this.numRentalDays + " ";
  }
}
