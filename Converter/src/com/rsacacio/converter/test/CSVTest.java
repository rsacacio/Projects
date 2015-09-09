package com.rsacacio.converter.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.rsacacio.converter.api.Person;
import com.rsacacio.converter.impl.CSVImpl;

public class CSVTest {

	private static final Logger logger = Logger.getLogger(CSVTest.class.getName());
	
	private static final String PERSONS_FIELDS = "id;name;gender;age";
	private static final String PERSONS_VALUES = "1;Paul;M;23";
	private static final String FILE_NAME = "file.csv";
	
	@Test
	public void convertPojoTest(){
		try {
			OutputStream outputStream = new CSVImpl().convert(this.createPerson());
			assert(outputStream != null);
			logger.log(Level.INFO, "convertPojoTest success...");
		} catch (IOException e) {
			fail("Error processing conversion: " + e.getMessage());
		}
	}
	
	@Test
	public void convertListTest(){
		try {
			OutputStream outputStream = new CSVImpl().convert(createPersons());
			assert(outputStream != null);
			logger.log(Level.INFO, "convertListTest success...");
		} catch (IOException e) {
			fail("Error processing conversion: " + e.getMessage());
		}
	}
	
	@Test
	public void getFieldsTest(){
		String sFields = new CSVImpl().getFields(new Person());
		assert(sFields != null);
		assert(PERSONS_FIELDS.equals(sFields));
		logger.log(Level.INFO, "getFieldsTest success...");
	}
	
	@Test
	public void getValuesTest(){
		String sValues = new CSVImpl().getValues(this.createPerson());
		assert(sValues != null);
		assert(PERSONS_VALUES.equals(sValues));
		logger.log(Level.INFO, "getValuesTest success...");
	}

	@Test
	public void getFileNameTest(){
		String sFileName = new CSVImpl().getFileName();
		assert(sFileName != null);
		assert(FILE_NAME.equals(sFileName));
		logger.log(Level.INFO, "getFileNameTest success...");
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