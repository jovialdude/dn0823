package com.example.pos.beans.request;

import org.springframework.stereotype.Component;

@Component
public class AgreementCreationRequest {
  private String code;
  private String startDate;
  private int duration;
  private int discount;

  public AgreementCreationRequest() {}

  public AgreementCreationRequest(String code, String startDate, int duration, int discount) {
    this.code=code;
    this.startDate=startDate;
    this.duration = duration;
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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getDiscount() { return discount; }

  public void setDiscount(int discount) { this.discount=discount; }

  public String toString() {
    return this.code + " "
        + this.startDate + " "
        + this.duration + " "
        + this.discount;
  }
}
