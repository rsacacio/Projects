package com.rsacacio.converter.factory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.rsacacio.converter.api.TYPE;
import com.rsacacio.converter.impl.CSVImpl;

/**
 * Factory for converter pojo to extension type
 * @author rangelsouza
 */
public class ConverterFactory {
	
	public static <T> OutputStream executeConverter(T instance, TYPE type) throws IOException{
		switch (type) {
			case CSV:
				return new CSVImpl().convert(instance);
			case XML:
			case JSON:
			default:
				throw new IllegalArgumentException("Conversion type not supported: " + type.name());
		}
	}
	
	public static <T> OutputStream executeConverterList(List<T> instances, TYPE type) throws IOException{
		switch (type) {
			case CSV:
				return new CSVImpl().convert(instances);
			case XML:
			case JSON:
			default:
				throw new IllegalArgumentException("Conversion type not supported: " + type.name());
		}
	}
}