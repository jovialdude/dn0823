package com.example.pos.beans.charge;

import org.springframework.stereotype.Component;

@Component
public class RentalCharge {
  double grossCharge;
  double discountedAmount;
  double netCharge;
  int discountPercentage;

  public RentalCharge(){}

  public RentalCharge(double grossCharge, double discountedAmount, double netCharge, int discountPercentage) {
    this.grossCharge = grossCharge;
    this.discountedAmount = discountedAmount;
    this.netCharge = netCharge;
    this.discountPercentage = discountPercentage;
  }

  public double getGrossCharge() {
    return grossCharge;
  }

  public void setGrossCharge(double grossCharge) {
    this.grossCharge = grossCharge;
  }

  public double getDiscountedAmount() {
    return discountedAmount;
  }

  public void setDiscountedAmount(double discountedAmount) {
    this.discountedAmount = discountedAmount;
  }

  public double getNetCharge() {
    return netCharge;
  }

  public void setNetCharge(double netCharge) {
    this.netCharge = netCharge;
  }

  public int getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(int discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public String toString () {
    return this.grossCharge + " " 
        + this.discountedAmount + " "
        + this.netCharge + " "
        + this.discountPercentage + " ";
  }
}
