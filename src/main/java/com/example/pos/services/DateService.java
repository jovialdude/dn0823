package com.example.pos.services;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
  This class will determine the number of paid days
 */
@Component
public class DateService {
  public DateService(){}

  public void calculate(String startDate, int numDate) throws ParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    LocalDate date = LocalDate.parse(startDate, formatter);
    LocalDate dueDate = date.plusDays((long)numDate);

    System.out.println(date);
    System.out.println(dueDate);
  }
}
