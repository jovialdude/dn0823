package com.example.pos.services;

import com.example.pos.beans.Charge;
import com.example.pos.beans.RentalDate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.beans.tool.Type;
import com.example.pos.repository.ToolDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class CheckoutService {
  DateService dateService;
  ToolDAOImpl toolDaoImpl;
  DiscountCalculationService discountCalculationService;
  AgreementService agreementService;

  public CheckoutService(){}

  @Autowired
  public CheckoutService(DateService dateService,
                         ToolDAOImpl toolDaoImpl,
                         DiscountCalculationService discountCalculationService,
                         AgreementService agreementService) {
    this.dateService=dateService;
    this.toolDaoImpl=toolDaoImpl;
    this.discountCalculationService = discountCalculationService;
    this.agreementService = agreementService;
  }

//  public void

  public void process (String toolCode, String rentalStart, int rentalDays, int discountPercentage) throws ParseException {
    if (rentalDays<=1) {
      throw new RuntimeException("Please enter a value greater than 1!");
    }
    if (discountPercentage<0 || discountPercentage > 100) {
      throw new RuntimeException("Invalid discount amount. Please enter a value between 1-100");
    }

//    System.out.println("Start checkout process");
    Tool tool = toolDaoImpl.getTool(toolCode);

    RentalDate rentalDate = dateService.process(rentalStart, rentalDays, tool.getType());

    Charge charge = discountCalculationService.process(rentalDate.getRate(), rentalDays, discountPercentage);

    agreementService.process(tool, rentalDate, charge);

//    System.out.println("Finish checkout process");
  }
}
