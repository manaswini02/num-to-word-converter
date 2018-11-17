package com.manaswini.virtusa.services;

import com.manaswini.virtusa.exception.InvalidDataException;

public interface Converter {
	
	String convertToWord(int number) throws InvalidDataException;

}
