package com.example.pos.services;

import com.example.pos.beans.RentalDate;
import com.example.pos.beans.rate.Rate;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

@Component
public class DateCalculationService {
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
  private String INDEPENDENCE_DAY_USA = "07/04/";
  private String LABOR_DAY_USA = "09/01/";

  public DateCalculationService(){}

  //
  //guarantee discounted for the holidays once in checkForJulyForth
  // bit of confusion here
  // if you rent a chainsaw and july 4th is on a sunday
  // your rental also expires on sunday
  // do you count the discount?
  //
  private int checkForJulyForth(LocalDate startDate, LocalDate dueDate) {
    int ans = 0;
    int year = startDate.getYear()%100;
    String independenceDayUSA = this.INDEPENDENCE_DAY_USA+year;
    LocalDate holiday = LocalDate.parse(independenceDayUSA, formatter);
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
    int year = startDate.getYear()%100;
    String laborDayUSA = this.LABOR_DAY_USA+year;
    LocalDate holiday = LocalDate.parse(laborDayUSA, formatter).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

    if (startDate.isEqual(holiday) || dueDate.isEqual(holiday) ||
        (startDate.isBefore(holiday) && dueDate.isAfter(holiday))) {
      ans += 1;
    }

    return ans;
  }

  private int holidayDiscountCheck(LocalDate startDate, LocalDate dueDate) {
    return checkForJulyForth(startDate, dueDate)
        + checkForLaborDay(startDate, dueDate);
  }

  private int weekendDiscountCheck(LocalDate startDate, LocalDate dueDate) {
    int res = 0;

    Predicate<LocalDate> weekendFilter = date->(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
        date.getDayOfWeek().equals(DayOfWeek.SUNDAY));

    long numWeekend = (startDate.plusDays(1L)).datesUntil(dueDate.plusDays(1L)).filter(weekendFilter).count();
    return res;
  }

  public int getDaysDiscounted(LocalDate startDate, LocalDate dueDate, Rate rate) {
    int numDayDiscounted = 0;
    if (rate.isHoliday()) {
      numDayDiscounted+=holidayDiscountCheck(startDate, dueDate);
    }
    if (rate.isWeekend()) {
      numDayDiscounted+=weekendDiscountCheck(startDate, dueDate);
    }

    return numDayDiscounted;
  }

  /**
   *
   * @param startDateString - date the customer book the rental
   * @param numDays - number of days the rental is checked out
   * @return
   */
  public RentalDate process(String startDateString, int numDays, Rate rate){
    LocalDate startDate = LocalDate.parse(startDateString, formatter);
    LocalDate dueDate = startDate.plusDays((long)numDays);

    int daysCharged = numDays - getDaysDiscounted(startDate, dueDate, rate);

    return new RentalDate(startDate, dueDate, numDays, daysCharged);
  }
}
