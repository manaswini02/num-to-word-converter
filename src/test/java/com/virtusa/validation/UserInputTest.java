package com.virtusa.validation;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.exception.InvalidDataException;

public class UserInputTest {

	UserInput userInput;

	@BeforeClass
	public static void setUp() {
	}

	@Test
	public void valid_integer_test() throws Exception {
		userInput = new UserInput("54546");
		assertEquals(54546, userInput.validate());
	}

	@Test(expected = InvalidDataException.class)
	public void invalid_integer_test() throws Exception {
		userInput = new UserInput("string");
		userInput.validate();
	}
	
	@Test(expected = InvalidDataException.class)
	public void invalid_integer_test2() throws Exception {
		userInput = new UserInput("@%$$&*");
		userInput.validate();
	}

	@Test(expected = RuntimeException.class)
	public void out_of_range_integer_test() throws Exception {
		userInput = new UserInput("-546");
		userInput.validate();
	}

	@Test(expected = RuntimeException.class)
	public void out_of_range_integer_test2() throws Exception {
		userInput = new UserInput("1245963698");
		userInput.validate();
	}
}
