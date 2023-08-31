package com.example.pos.beans.request;

import org.springframework.stereotype.Component;

@Component
public class AgreementCreationRequest {
  private String code;
  private String startDate;
  private int numRentalDays;
  private int discount;

  public AgreementCreationRequest() {}

  public AgreementCreationRequest(String code, String startDate, int numRentalDays, int discount) {
    this.code=code;
    this.startDate=startDate;
    this.numRentalDays=numRentalDays;
    this.discount=discount;
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

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public int getNumRentalDays() {
    return numRentalDays;
  }

  public void setNumRentalDays(int numRentalDays) {
    this.numRentalDays = numRentalDays;
  }

  public int getDiscount() { return discount; }

  public void setDiscount(int discount) { this.discount=discount; }

  public String toString() {
    return this.code + " "
        + this.startDate + " "
        + this.numRentalDays + " "
        + this.discount;
  }
}
