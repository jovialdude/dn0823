package com.example.pos.services;

import com.example.pos.beans.RentalDate;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.repository.interfaces.RateRepository;
import com.example.pos.repository.interfaces.ToolRepository;
import com.example.pos.services.interfaces.AgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
@Primary
public class AgreementCreationService implements AgreementService {
  @Autowired
  ToolRepository toolRepository;
  @Autowired
  RateRepository rateRepository;
  @Autowired
  DateCalculationService dateCalculationService;

  public AgreementCreationService(){}

  private final Logger logger = LoggerFactory.getLogger(AgreementCreationService.class);

  @Override
  public void process(Agreement agreement) {
    Tool tool = toolRepository.findById(agreement.getCode()).get();
    logger.info(tool.toString());
    Rate rate = rateRepository.findById(tool.getType()).get();

    RentalDate rentalDate = dateCalculationService.process(agreement.getStartDate(), agreement.getNumRentalDays(), rate);
    logger.info(rentalDate.toString());
  }
}
