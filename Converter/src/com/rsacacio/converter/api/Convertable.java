package com.rsacacio.converter.api;

public interface Convertable {

	<T> String getFields(T instance);
	
	<T> String getValues(T instance);
	
	String getFileName();

}
