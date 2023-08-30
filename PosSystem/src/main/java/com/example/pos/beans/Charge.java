package com.example.pos.beans;

public class Charge {
  double grossAmount;
  double discountedAmount;
  double netAmount;
  double dailyRate;
  int discountPercentage;

  public Charge(){}

  public Charge(double grossAmount, double discountedAmounted, double netAmount, double dailyRate, int discountPercentage) {
    this.grossAmount = grossAmount;
    this.discountedAmount = discountedAmounted;
    this.netAmount = netAmount;
    this.dailyRate = dailyRate;
    this.discountPercentage = discountPercentage;
  }

  public double getGrossAmount() {
    return grossAmount;
  }

  public double getDiscountedAmount() {
    return discountedAmount;
  }

  public double getNetAmount() {
    return netAmount;
  }

  public double getDailyRate() {
    return dailyRate;
  }

  public int getDiscountPercentage() {
    return discountPercentage;
  }
}
