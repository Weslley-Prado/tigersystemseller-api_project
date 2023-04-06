package com.tigersystemseller.util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtils {
	
	 private static final String DEFAULT_FORMAT_DATE = "dd/MM/yyyy";
	public static final Date DATE_START_DEFAULT;
	 
	 static {
		 DATE_START_DEFAULT = DateUtils.fromString("01/01/1970");
	 }
	public static Date fromString(String dateString) {
			return fromString(dateString, false);
		}
	public static Date fromString(String dateString, boolean atEndOfDay) {
		if(!StringUtils.hasText(dateString)) {
			return null;
		}
		var date = LocalDate.parse(dateString,DateTimeFormatter.ofPattern(DEFAULT_FORMAT_DATE));
		LocalDateTime dateHour;

		if(atEndOfDay) {
			dateHour = date.atTime(LocalTime.of(00,00,00)).plusDays(1);
		}else {
			dateHour = date.atStartOfDay();
		}
		var instant = dateHour.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}
	
	public static Date today(boolean atEndOfDay) {
		String dateTodayFormatted = LocalDate.now().format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT_DATE));
		return fromString(dateTodayFormatted, atEndOfDay);
	}
}
