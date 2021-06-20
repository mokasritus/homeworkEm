package calculator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Helper {

  public LocalDateTime setResolvedDate(LocalDateTime submitDate, int days) {
    LocalDateTime result = submitDate;
    if (days == 0 && submitDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
        submitDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
      days++;
    }
    int addedDays = 0;
    while (addedDays < days) {
      result = result.plusDays(1);
      if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
          result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
        ++addedDays;
      }
    }
    return result;
  }

  public LocalDateTime setResolvedTime(LocalDateTime dateTime, int hours) {
    LocalDateTime result = dateTime;

    List<Integer> workingHours;
    if (dateTime.getMinute() == 0 && dateTime.getSecond() == 0 && dateTime.getNano() == 0) {
      workingHours = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);
    } else {
      workingHours = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16);
    }

    int submittedHour = dateTime.getHour();
    int maxWorkingHour = Collections.max(workingHours);
    int hoursCanBeAddedToday = maxWorkingHour - submittedHour;

    if (hoursCanBeAddedToday < hours) {
      int addedhours = 0;
      while (addedhours < hours) {
        result = result.plusHours(1);
        if (workingHours.contains(result.getHour())) {
          ++addedhours;
        }
      }
    } else {
      result = result.plusHours(hours);
    }
    return result;
  }
}
