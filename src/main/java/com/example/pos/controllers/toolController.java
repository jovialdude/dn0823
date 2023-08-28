package com.example.pos.controllers;

import com.example.pos.beans.agreement.Agreement;
import com.example.pos.exceptions.InvalidDayCountException;
import com.example.pos.services.interfaces.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class toolController {
  @Autowired
  private AgreementService agreementCreationService;

  @GetMapping("/getToolContract")
  public void getToolContract(String code, String checkoutDate, int numRentalDays) throws ParseException {
    if (numRentalDays<1){
      String message = "Expected more than days. Received" + numRentalDays;
      throw new InvalidDayCountException(message, new RuntimeException());
    }

    Agreement agreement = new Agreement(code, checkoutDate, numRentalDays);
    agreementCreationService.process(agreement);
  }
}
