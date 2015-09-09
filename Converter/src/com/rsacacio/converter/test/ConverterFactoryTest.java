package com.rsacacio.converter.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.rsacacio.converter.api.Person;
import com.rsacacio.converter.api.TYPE;
import com.rsacacio.converter.factory.ConverterFactory;

public class ConverterFactoryTest {

	private static final Logger logger = Logger.getLogger(ConverterFactoryTest.class.getName());
	
	@Test
	public void convertPojoCSVTest() {
		try {
			OutputStream outputStream = ConverterFactory.executeConverter(this.createPerson(), TYPE.CSV);
			assert(outputStream != null);
			logger.log(Level.INFO, "convertPojoCSVTest success...");
		} catch (IOException e) {
			fail("Error processing conversion: " + e.getMessage());
		}
	}

	@Test
	public void convertListCSVTest() {
		try {
			OutputStream outputStream = ConverterFactory.executeConverter(this.createPersons(), TYPE.CSV);
			assert(outputStream != null);
			logger.log(Level.INFO, "convertListCSVTest success...");
		} catch (IOException e) {
			fail("Error processing conversion: " + e.getMessage());
		}
	}
	
	private Person createPerson() {
		return new Person(1, "Paul", "M", 23);
	}
	
	private List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1, "Paul", "M", 18));
		persons.add(new Person(2, "John", "M", 39));
		persons.add(new Person(3, "Ellen", "F", 23));
		return persons;
	}
	
}
