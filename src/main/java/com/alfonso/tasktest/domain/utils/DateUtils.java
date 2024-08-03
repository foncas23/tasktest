package com.alfonso.tasktest.domain.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateUtils {

  private DateUtils() {}

  public static LocalDateTime stringToLocalDateTime(String dateStr) {
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return LocalDateTime.parse(dateStr, formatter);
    } catch (DateTimeParseException e) {
      throw new RuntimeException("Date format not valid");
    }
  }
}
