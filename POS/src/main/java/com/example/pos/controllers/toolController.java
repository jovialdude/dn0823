package com.example.pos.controllers;

import com.example.pos.beans.agreement.Agreement;
import com.example.pos.exceptions.InvalidDayCountException;
import com.example.pos.services.interfaces.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class toolController {
  @Autowired
  private AgreementService agreementCreationService;

  @PostMapping("/getToolContract")
  public ResponseEntity<Agreement> getToolContract(String code, String checkoutDate, int numRentalDays) throws ParseException {
    if (numRentalDays<1){
      String message = "Expected more than days. Received" + numRentalDays;
//      throw new InvalidDayCountException(message, new RuntimeException());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    Agreement agreement = new Agreement();
    agreement.setCode(code);
    agreement.setStartDate(checkoutDate);
    agreement.setNumRentalDays(numRentalDays);
    agreementCreationService.process(agreement);

    return new ResponseEntity<Agreement>(agreement, HttpStatus.OK);
  }
}
