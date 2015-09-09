package com.rsacacio.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rsacacio.converter.api.Person;
import com.rsacacio.converter.api.TYPE;
import com.rsacacio.converter.factory.ConverterFactory;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		try {
			ConverterFactory.executeConverter(new Person(1, "Paul", "M", 18), TYPE.CSV);
			ConverterFactory.executeConverter(createPersons(), TYPE.CSV);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Error processing conversion: " + e.getMessage());
		}
	}

	private static List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1, "Paul", "M", 18));
		persons.add(new Person(2, "John", "M", 39));
		persons.add(new Person(3, "Ellen", "F", 23));
		return persons;
	}
	
}
