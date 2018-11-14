package com.virtusa.validation;

import com.virtusa.exception.InvalidDataException;

/**
 * @Author Manaswini Nalamuthu
 *
 *  UserInput class validates input data
 *  
 */
public class UserInput {
	
	private String inputData;
	
	public UserInput(String inputData){
		this.inputData = inputData;
	}
	
	public int validate() throws InvalidDataException{
		int validNumber;
		try{
			validNumber = Integer.parseInt(inputData);
		}
		catch (NumberFormatException e) {
			throw new InvalidDataException(" Enter an integer value");
		}
		if(validNumber <= 0 || validNumber > 999999999){
			throw new RuntimeException("Integer must be in the range  [0, 999999999] ");
		}
		return validNumber;
	}

}
