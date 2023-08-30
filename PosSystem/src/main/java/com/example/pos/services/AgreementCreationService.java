package com.example.pos.services;

import com.example.pos.beans.RentalDate;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.services.interfaces.AgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Primary
public class AgreementCreationService implements AgreementService {
  @Autowired
  DateCalculationService dateCalculationService;

  private String BASE_URL="http://localhost:8282";

  public AgreementCreationService(){}

  private final Logger logger = LoggerFactory.getLogger(AgreementCreationService.class);

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
  public void process(Agreement agreement) {
    logger.info(agreement.toString());
    Tool tool = getTool(agreement.getCode());
    logger.info(tool.toString());
    Rate rate = getRate(tool.getType());
    logger.info(rate.toString());

    RentalDate rentalDate = dateCalculationService.process(agreement.getStartDate(), agreement.getNumRentalDays(), rate);
    logger.info(rentalDate.toString());
  }
}
