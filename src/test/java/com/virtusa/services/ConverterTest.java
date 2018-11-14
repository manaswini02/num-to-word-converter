package com.virtusa.services;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.services.ConverterImpl;

public class ConverterTest {

	private static ConverterImpl converter;
	
	@BeforeClass
	public static void setUp() {
		converter = new ConverterImpl();
			}
	
	@Test
	public void valid_scenarios_test()  {
		assertEquals("one",converter.convertToWord(1));
		assertEquals("fifteen",converter.convertToWord(15));
		assertEquals("thirty one",converter.convertToWord(31));
		assertEquals("one hundred and one",converter.convertToWord(101));
		assertEquals("nine hundred and ninety nine",converter.convertToWord(999));
		assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",converter.convertToWord(999999999));
	
	}
		
}
