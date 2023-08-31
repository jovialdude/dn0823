package com.example.pos.beans.charge;

public class RentalCharge {
  double grossCharge;
  double discountedAmount;
  double netCharge;
  double dailyRate;
  int discountPercentage;

  public RentalCharge(){}

  public RentalCharge(double grossCharge, double discountedAmounted, double netCharge, double dailyRate, int discountPercentage) {
    this.grossCharge = grossCharge;
    this.discountedAmount = discountedAmounted;
    this.netCharge = netCharge;
    this.dailyRate = dailyRate;
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

  public double getnetCharge() {
    return netCharge;
  }

  public void setnetCharge(double netCharge) {
    this.netCharge = netCharge;
  }

  public double getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(double dailyRate) {
    this.dailyRate = dailyRate;
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
        + this.dailyRate + " "
        + this.discountPercentage + " ";
  }
}
