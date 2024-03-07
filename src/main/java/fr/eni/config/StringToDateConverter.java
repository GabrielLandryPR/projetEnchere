package fr.eni.config;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

	private final SimpleDateFormat dateFormat;

	public StringToDateConverter() {
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.dateFormat.setLenient(false);
	}

	@Override
	public Date convert(String source) {
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use the format: yyyy-MM-dd");
		}
	}
}
