package com.virtusa.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.virtusa.exception.InvalidDataException;

public class UserInputTest {

	UserInputImpl userInput;

	@Before
	public void setUp() {
		userInput = new UserInputImpl();
	}

	@Test
	public void valid_integer_test() throws Exception {

		assertEquals(54546, userInput.validate("54546"));
	}

	@Test(expected = InvalidDataException.class)
	public void invalid_integer_test() throws Exception {
		userInput.validate("string");
	}

	@Test(expected = InvalidDataException.class)
	public void invalid_integer_test2() throws Exception {
		userInput.validate("@%$$&*");
	}

	@Test(expected = RuntimeException.class)
	public void out_of_range_integer_test() throws Exception {
		userInput.validate("-546");
	}

	@Test(expected = RuntimeException.class)
	public void out_of_range_integer_test2() throws Exception {
		userInput.validate("1245963698");
	}
}
