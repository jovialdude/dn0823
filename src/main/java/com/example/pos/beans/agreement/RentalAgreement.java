package com.example.pos.beans.agreement;

import com.example.pos.beans.Charge;
import com.example.pos.beans.RentalDate;
import com.example.pos.beans.tool.Tool;

public class RentalAgreement {
  Tool tool;
  RentalDate rentalDate;
  Charge charge;

  public RentalAgreement(){}

  public RentalAgreement(Tool tool, RentalDate rentalDate, Charge charge) {
    this.tool=tool;
    this.rentalDate=rentalDate;
    this.charge=charge;
  }
}
