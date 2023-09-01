package com.example.pos.controllers;

import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.services.interfaces.AgreementGeneration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class AgreementController {
  @Autowired
  private AgreementGeneration agreementCreationService;


  @GetMapping("/getAgreement")
  public ResponseEntity<String> getToolContract(@RequestParam String code, @RequestParam String date,
                                                @RequestParam int days, @RequestParam int discount) throws ParseException, JsonProcessingException {
    if (days<1){
      String message = "Expected more than days. Received " + days;
//      throw new InvalidDayCountException(message, new RuntimeException());
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    if(discount>100 || discount<0) {
      String message = "Expected discount value between 0-100. Received " + discount;
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    ObjectMapper objectMapper = new ObjectMapper();

    AgreementCreationRequest agreementCreationRequest = new AgreementCreationRequest();
    agreementCreationRequest.setCode(code);
    agreementCreationRequest.setStartDate(date);
    agreementCreationRequest.setNumRentalDays(days);
    agreementCreationRequest.setDiscount(discount);

    Agreement agreement = new Agreement();

    agreementCreationService.process(agreementCreationRequest, agreement);

    return new ResponseEntity<String>(objectMapper.writeValueAsString(agreement),HttpStatus.OK);
  }
}
