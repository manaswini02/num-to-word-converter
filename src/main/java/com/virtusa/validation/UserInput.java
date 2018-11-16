package com.virtusa.validation;

import com.virtusa.exception.InvalidDataException;

public interface UserInput {
	
	int validate(String inputData) throws InvalidDataException;

}
