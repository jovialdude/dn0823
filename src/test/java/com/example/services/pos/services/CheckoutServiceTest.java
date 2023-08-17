package com.example.services.pos.services;

import com.example.pos.repository.ToolDAOImpl;
import com.example.pos.services.AgreementService;
import com.example.pos.services.CheckoutService;

import com.example.pos.services.DateService;
import com.example.pos.services.DiscountCalculationService;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class CheckoutServiceTest {

  private CheckoutService checkoutService;
  private ClassLoader classLoader;
  private DateService dateService;
  private ToolDAOImpl toolDaoImpl;
  private DiscountCalculationService discountCalculationService;
  private AgreementService agreementService;

  {
    dateService = new DateService();
    toolDaoImpl = new ToolDAOImpl();
    discountCalculationService = new DiscountCalculationService();
    agreementService = new AgreementService();
    checkoutService = new CheckoutService(dateService, toolDaoImpl, discountCalculationService, agreementService);
    classLoader = getClass().getClassLoader();
  }

  @Test
  public void testCheckOutProcess() throws FileNotFoundException, ParseException {
    File file = new File(classLoader.getResource("testFile1.txt").getFile());

    Scanner scanner = new Scanner(file);

    while(scanner.hasNext()) {
      String newLine = scanner.nextLine();
      String toolCode = scanner.nextLine().trim();
      String date = scanner.nextLine().trim();
      int numDays = scanner.nextInt();
      int discount = scanner.nextInt();
      checkoutService.process(toolCode, date, numDays, discount);
    }
  }

}
