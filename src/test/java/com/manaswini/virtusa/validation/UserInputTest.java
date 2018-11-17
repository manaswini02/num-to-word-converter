package com.manaswini.virtusa.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.manaswini.virtusa.exception.InvalidDataException;
import com.manaswini.virtusa.validation.UserInputImpl;

public class UserInputTest {

	UserInputImpl userInput;

	@Before
	public void setUp() {
		userInput = new UserInputImpl();
	}

	@Test
	public void validIntegerTest() throws Exception {

		assertEquals(54546, userInput.validate("54546"));
	}
	
	@Test
	public void zeroScenarioTest() throws Exception {

		assertEquals(0, userInput.validate("0"));
	}

	@Test(expected = InvalidDataException.class)
	public void stringInputTest() throws Exception {
		userInput.validate("string");
	}

	@Test(expected = InvalidDataException.class)
	public void specialKeysTest() throws Exception {
		userInput.validate("@%$$&*");
	}

	@Test(expected = RuntimeException.class)
	public void negativeValueTest() throws Exception {
		userInput.validate("-546");
	}

	@Test(expected = RuntimeException.class)
	public void outOfRangeTest() throws Exception {
		userInput.validate("1245963698");
	}
}
