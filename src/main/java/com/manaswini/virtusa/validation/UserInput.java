package com.manaswini.virtusa.validation;

import com.manaswini.virtusa.exception.InvalidDataException;

public interface UserInput {
	
	int validate(String inputData) throws InvalidDataException;

}
