package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.services.interfaces.AgreementGeneration;
import com.example.pos.services.interfaces.ChargeCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Component
@Primary
public class AgreementGenerationService implements AgreementGeneration {
  @Autowired
  DateCalculationService dateCalculationService;

  @Autowired
  ChargeCalculation chargeCalculationService;

  private String BASE_URL="http://localhost:8282";

  public AgreementGenerationService(){}

  private final Logger log = LoggerFactory.getLogger(AgreementGenerationService.class);

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

  private void logAgreement(Agreement agreement) {
    String string = "";
    DecimalFormat dcf = new DecimalFormat("#,###.##");
    dcf.setRoundingMode(RoundingMode.HALF_UP);

    string+="Tool Code: " + agreement.getTool().getCode() + "\n";
    string+="Tool Type: " + agreement.getTool().getType() + "\n";
    string+="Tool Brand: " + agreement.getTool().getBrand() + "\n";
    string+="Rental Days: " + agreement.getRentalDatesDetails().getDuration() + "\n";
    string+="Checkout Date: " + agreement.getRentalDatesDetails().getStartDate() + "\n";
    string+="Due Date: " + agreement.getRentalDatesDetails().getEndDate() + "\n";
    string+="Daily Rate: $" + dcf.format(agreement.getRentalDatesDetails().getDailyRate()) + "\n";
    string+="Charged Days: " + agreement.getRentalDatesDetails().getDaysCharged() + "\n";
    string+="Pre-discount Charge: $" + dcf.format(agreement.getCharge().getGrossCharge()) + "\n";
    string+="Discount Percent: " + agreement.getCharge().getDiscountPercentage() + "\n";
    string+="Discount Amount: $" + dcf.format(agreement.getCharge().getDiscountedAmount()) + "\n";
    string+="Final Charge: $" + dcf.format(agreement.getCharge().getNetCharge()) + "\n";

    log.info("Logging Contract Details"+ "\n" + string);
  }

  @Override
  public void process(AgreementCreationRequest agreementCreationRequest, Agreement agreement) {
    log.info("Begin agreement generation process");
    log.debug(agreementCreationRequest.toString());
    Tool tool = getTool(agreementCreationRequest.getCode());
    log.debug(tool.toString());
    Rate rate = getRate(tool.getType());
    log.debug(rate.toString());

    RentalDatesDetails rentalDatesDetails = new RentalDatesDetails();
    dateCalculationService.process(agreementCreationRequest.getStartDate(), agreementCreationRequest.getDuration(), rate, rentalDatesDetails);
    log.debug(rentalDatesDetails.toString());

    RentalCharge rentalCharge = new RentalCharge();
    chargeCalculationService.process(rate.getDailyCharge(), rentalDatesDetails.getDaysCharged(), agreementCreationRequest.getDiscount(), rentalCharge);
    log.debug(rentalDatesDetails.toString());

    agreement.setTool(tool);
    agreement.setRentalDatesDetails(rentalDatesDetails);
    agreement.setRentalCharge(rentalCharge);

    logAgreement(agreement);
    log.info("Finish agreement generation process");
  }
}
