package com.example.pos.services;

import com.example.pos.beans.RatesBook;
import com.example.pos.beans.RentalDate;
import com.example.pos.beans.tool.Type;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/*
  This class will determine the number of paid days
  Qxn: how will it handle multiple year rental ie 12/30/2022-5/1/2023
 */
@Component
public class DateService {
  private String INDEPENDENCE_DAY_USA = "07/04";
  private String LABOR_DAY_USA = "09/01";
  public DateService(){}

  //
  //guarantee discounted for the holidays once in checkForJulyForth
  // bit of confusion here
  // if you rent a chainsaw and july 4th is on a sunday
  // your rental also expires on sunday
  // do you count the discount?
  //
  private int checkForJulyForth(LocalDate startDate, LocalDate dueDate) {
    int ans = 0;
    int year = startDate.getYear();
    String independenceDayUSA = this.INDEPENDENCE_DAY_USA+year;
    LocalDate holiday = LocalDate.parse(independenceDayUSA);
    if (holiday.getDayOfWeek() == DayOfWeek.SATURDAY) {
      holiday = holiday.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    }
    else if (holiday.getDayOfWeek() == DayOfWeek.SUNDAY) {
      holiday = holiday.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }

    if (startDate.isEqual(holiday) || dueDate.isEqual(holiday) ||
        (startDate.isBefore(holiday) && dueDate.isAfter(holiday))) {
      ans += 1;
    }

    return ans;
  }

  private int checkForLaborDay(LocalDate startDate, LocalDate dueDate) {
    int ans = 0;
    int year = startDate.getYear();
    String laborDayUSA = this.LABOR_DAY_USA+year;
    LocalDate holiday = LocalDate.parse(laborDayUSA).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

    if (startDate.isEqual(holiday) || dueDate.isEqual(holiday) ||
        (startDate.isBefore(holiday) && dueDate.isAfter(holiday))) {
      ans += 1;
    }

    return ans;
  }


  //
  // I try to optimize too much
  // i want to make holidayDiscountCheck such that
  // it does not need to be modified for every new holiday
  //
  private int holidayDiscountCheck(LocalDate startDate, LocalDate dueDate) {
    return checkForJulyForth(startDate, dueDate)
        + checkForLaborDay(startDate, dueDate);
  }

  private int weekendDiscountCheck(LocalDate startDate, LocalDate dueDate) {
    int res = 0;
//    LocalDate nextWeekMonday = startDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

    //i'm making an assumption that the rental will take less than a week in total
    // and the weekend will fall between the dates
    // the two will

//    if (startDate.isEqual())

    return res;
  }

  public int getDaysDiscounted(LocalDate startDate, LocalDate dueDate, Type type) {
    int numDayDiscounted = 0;
    if (RatesBook.getRate(type).isHoliday()) {
      numDayDiscounted+=holidayDiscountCheck(startDate, dueDate);
    }
    if (RatesBook.getRate(type).isWeekend()) {
      numDayDiscounted+=weekendDiscountCheck(startDate, dueDate);
    }

    return numDayDiscounted;
  }

  /**
   *
   * @param startDateString - date the customer book the rental
   * @param numDays - number of days the rental is checked out
   * @param type - type of tool being checked out
   * @return
   * @throws ParseException
   */
  public RentalDate calculate(String startDateString, int numDays, Type type) throws ParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    LocalDate startDate = LocalDate.parse(startDateString, formatter);
    LocalDate dueDate = startDate.plusDays((long)numDays);
    int daysCharged = numDays - getDaysDiscounted(startDate, dueDate, type);


    System.out.println(startDate);
    System.out.println(dueDate);
//    System.out.println(totalFees);
    return new RentalDate(startDate, dueDate, numDays, daysCharged);
  }
}
