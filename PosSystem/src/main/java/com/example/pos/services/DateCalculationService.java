package com.example.pos.services;

import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.rate.Rate;
import com.example.pos.services.interfaces.DateCalculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class DateCalculationService implements DateCalculation {
  private final DateTimeFormatter formatter;
  private String INDEPENDENCE_DAY_USA = "07/04/";
  private String LABOR_DAY_USA = "09/01/";

  private final Logger log = LoggerFactory.getLogger(DateCalculationService.class);
  public DateCalculationService(){
    formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
  }

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

  private int countHolidays(LocalDate startDate, LocalDate dueDate) {
    return checkForJulyForth(startDate, dueDate)
        + checkForLaborDay(startDate, dueDate);
  }

  private int countWeekendDays(LocalDate startDate, LocalDate dueDate) {
    Predicate<LocalDate> weekendFilter =
        date->
            (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
            );

    List<LocalDate> numBusinessDays =
        (startDate.plusDays(1L))
            .datesUntil(dueDate.plusDays(1L))
            .filter(weekendFilter).collect(Collectors.toList());
    return numBusinessDays.size();
  }

  public int getDaysDiscounted(LocalDate startDate, LocalDate dueDate, Rate rate) {
    int numDayDiscounted = 0;
    if (!rate.isChargeHoliday()) {
      numDayDiscounted+= countHolidays(startDate, dueDate);
    }
    if (!rate.isChargeWeekend()) {
      numDayDiscounted+= countWeekendDays(startDate, dueDate);
    }

    return numDayDiscounted;
  }

  /**
   *
   * @param startDateString - date the customer book the rental
   * @param numDays - number of days the rental is checked out
   * @return
   */
  @Override
  public void process(String startDateString, int numDays, Rate rate, RentalDatesDetails rentalDatesDetails){
    log.info("Start date calculation process");
    LocalDate startDate = LocalDate.parse(startDateString, formatter);
    LocalDate dueDate = startDate.plusDays((long)numDays);

    int daysCharged = numDays - getDaysDiscounted(startDate, dueDate, rate);

    rentalDatesDetails.setStartDate(startDateString);
    rentalDatesDetails.setEndDate(dueDate.format(formatter));
    rentalDatesDetails.setDuration(numDays);
    rentalDatesDetails.setDaysCharged(daysCharged);
    rentalDatesDetails.setRate(rate);
    log.info("Finish date calculation process");
  }
}
