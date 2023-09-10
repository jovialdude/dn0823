package com.example.pos.controllers;

import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.exceptions.InvalidDayCountException;
import com.example.pos.exceptions.InvalidDiscountPercentageException;
import com.example.pos.services.interfaces.AgreementGeneration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class AgreementController {
  @Autowired
  private AgreementGeneration agreementGenerationService;

  private final Logger log = LoggerFactory.getLogger(AgreementController.class);

  @PostMapping(value = "/getAgreement",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getToolContract(@RequestBody AgreementCreationRequest request) throws ParseException, JsonProcessingException {
    if (request.getDuration()<1){
      String message = "Expected more than days. Received " + request.getDuration();
      log.error(message, new InvalidDayCountException().getStackTrace());
//      return Mono.just( new ResponseEntity<>(message, HttpStatus.BAD_REQUEST));
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    if(request.getDiscount()>100 || request.getDiscount()<0) {
      String message = "Expected discount value between 0-100. Received " + request.getDiscount();
      log.error(message, new InvalidDiscountPercentageException().getStackTrace());
//      return Mono.
//          just(new ResponseEntity<>(message, HttpStatus.BAD_REQUEST));
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    Agreement agreement = new Agreement();

    agreementGenerationService.process(request, agreement);

//    return Mono.just(new ResponseEntity<>(objectMapper.writeValueAsString(agreement),HttpStatus.OK));
    return new ResponseEntity<>(objectMapper.writeValueAsString(agreement), HttpStatus.OK);
  }
}
