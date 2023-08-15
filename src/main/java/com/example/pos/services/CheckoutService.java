package com.example.pos.services;

import com.example.pos.beans.tool.Brand;
import com.example.pos.beans.tool.Tool;
import com.example.pos.beans.tool.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class CheckoutService {
  @Autowired
  DateService dateService;

  public void printBanner() {
    System.out.println("******************************************");
    System.out.println("**********Welcome to Rent-a-tool**********");
    System.out.println("******************************************");
  }

  public int promptForType() {
    String prompt = "Enter 1-3 >> ";
    System.out.print(prompt);
    int count = 0;
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    while(num<1 || num>=3) {
      prompt = "Invalid input! \n" +
          "Please enter value between 1-3 >> " ;
      System.out.print(prompt);
      num = scanner.nextInt();
    }
    return num;
  }

  public int promptForBrand() {
    String prompt = "Enter 1-4 >> ";
    System.out.print(prompt);
    Scanner scanner = new Scanner(System.in);
    int num= scanner.nextInt();
    while(num<1 || num>4) {
      prompt = "Invalid input! \n" +
          "Please enter value between 1-4 >> ";
      System.out.print(prompt);
      num = scanner.nextInt();
    }

    return num;
  }

  public Tool searchForTool(int type, int brand) {
    String brandInitials = Brand.getInitials(brand);
    String typeInitials = Type.getInitials(type);

    return new Tool(brandInitials + typeInitials,
        Brand.getBrand(brand).toString(),
        Type.getType(type).toString());
  }

  public void datePrompt() throws ParseException {
    String prompt = "Please enter a checkout date--mm/dd/yy >> ";
    Scanner scanner = new Scanner(System.in);
    System.out.println(prompt);
    String startDate = scanner.nextLine();

    prompt = "How many days would you need the item? ";
    System.out.println(prompt);
    int days = scanner.nextInt();

    dateService.calculate(startDate, days);
   }

//  public void

  public void process () throws ParseException {
    printBanner();
    int type = promptForType();
    int brand = promptForBrand();
    Tool tool = searchForTool(type, brand);
//    dateService.ca
    datePrompt();
//    System.out.println(?());



//    System.out.println(brand + " " + type);
  }
}
