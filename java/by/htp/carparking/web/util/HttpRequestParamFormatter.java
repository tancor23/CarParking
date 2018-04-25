package by.htp.carparking.web.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class HttpRequestParamFormatter {
	
	private HttpRequestParamFormatter() {}
	
	public static int formatStringToInt(String value){
		return Integer.parseInt(value);
    }

	public static LocalDate formatStringToLocalDate(String value){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(value, formatter);
    }
}
