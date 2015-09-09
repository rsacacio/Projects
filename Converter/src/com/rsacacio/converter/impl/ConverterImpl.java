package com.rsacacio.converter.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rsacacio.converter.api.Convertable;

/**
 * Conversion of abstraction.
 * @author rangelsouza
 */
public abstract class ConverterImpl implements Convertable{

	private static final Logger logger = Logger.getLogger(ConverterImpl.class.getName());
	
	private static final String UNDEFINED = "UNDEFINED";

	public <T> OutputStream convert(final T instance) throws IOException{
		List<T> instances = new ArrayList<T>();
		instances.add(instance);
		return this.convert(instances);
	}
	
	public <T> OutputStream convert(final List<T> instances) throws IOException{
		logger.log(Level.INFO, "Starting convert...");
		if(instances == null || instances.isEmpty()){
			throw new IllegalArgumentException("The instance is empty!!");
		}
		
		StringBuilder sb = new StringBuilder();
		for(T instance : instances){
			if(sb.length() == 0){
				sb.append(this.getFields(instance));
			}
			sb.append(this.getValues(instance));
		}
		return this.write(sb.toString(), this.getFileName());
	}

	private OutputStream write(final String content, String fileName) throws IOException{
		OutputStream out = null;
		Writer writer = null;
		try {
			out = new FileOutputStream(fileName);
			writer = new OutputStreamWriter(out);
			writer.write(content);
			writer.close();
			return out;
		} catch (IOException e) {
			logger.log(Level.WARNING, "Error writing file!!!!!");
			return null;
		}finally{
			out.close();
			writer.close();
		}
	}
	
	protected <T> String getField(final T instance, final Field field) {
		try {
			field.setAccessible(true);
			return String.valueOf(field.get(instance));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.log(Level.WARNING, "Error getting field value: " + field.getName());
			return UNDEFINED;
		}
	}
	
}