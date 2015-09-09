package com.rsacacio.converter.impl;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conversion implementation to csv.
 * @author rangelsouza
 */
public class CSVImpl extends ConverterImpl{

	private static final Logger logger = Logger.getLogger(CSVImpl.class.getName());
	
	private static final String SEPARATOR = ";";
	
	private static final String FILE = "file.csv";
	
	public String getFileName(){
		return FILE;
	}
	
	public <T> String getFields(final T instance) {
		logger.log(Level.INFO, "Getting the name of fields...");

		StringBuilder sb = new StringBuilder();
		for (Field field : instance.getClass().getDeclaredFields()) {
			sb.append(sb.length() > 0 ? SEPARATOR : "");
			sb.append(field.getName());
		}
		logger.log(Level.INFO, "Name of fields successfully got: " + sb.toString());
		sb.append("\n");
		return sb.toString();
	}
	
	public <T> String getValues(final T instance) {
		logger.log(Level.INFO, "Getting the value of fields...");
		StringBuilder sb = new StringBuilder();
		for (Field field : instance.getClass().getDeclaredFields()) {
			sb.append(sb.length() > 0 ? SEPARATOR : "");
			sb.append(this.getField(instance, field));
		}
		logger.log(Level.INFO, "Value of fields successfully got: " + sb.toString());
		sb.append("\n");
		return sb.toString();
	}
}