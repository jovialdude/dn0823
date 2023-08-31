package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.services.interfaces.AgreementGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Primary
public class AgreementGenerationService implements AgreementGeneration {
  @Autowired
  DateCalculationService dateCalculationService;

  private String BASE_URL="http://localhost:8282";

  public AgreementGenerationService(){}

  private final Logger logger = LoggerFactory.getLogger(AgreementGenerationService.class);

  public Tool getTool(String tool) {
    WebClient client = WebClient.builder()
        .baseUrl(BASE_URL)
        .build();

    Tool response = client.get()
        .uri(uriBuilder -> uriBuilder.path("/v1/getTool/" + tool).build())
        .retrieve()
        .bodyToMono(Tool.class)
        .block();

    return response;
  }

  public Rate getRate(String type) {
    WebClient client = WebClient.builder()
        .baseUrl(BASE_URL)
        .build();

    Rate response = client.get()
        .uri(uriBuilder -> uriBuilder.path("/v1/getRate/" + type).build())
        .retrieve()
        .bodyToMono(Rate.class)
        .block();

    return response;
  }

  @Override
  public void process(AgreementCreationRequest agreementCreationRequest, Agreement agreement) {
    logger.info(agreementCreationRequest.toString());
    Tool tool = getTool(agreementCreationRequest.getCode());
    logger.info(tool.toString());
    Rate rate = getRate(tool.getType());
    logger.info(rate.toString());

    RentalDatesDetails rentalDatesDetails = new RentalDatesDetails();
    dateCalculationService.process(agreementCreationRequest.getStartDate(), agreementCreationRequest.getNumRentalDays(), rate, rentalDatesDetails);
    logger.info(rentalDatesDetails.toString());

    agreement.setTool(tool);
    agreement.setRentalDatesDetails(rentalDatesDetails);
  }
}
