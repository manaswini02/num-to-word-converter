package com.virtusa;

import java.util.Scanner;

import com.virtusa.exception.InvalidDataException;
import com.virtusa.services.ConverterImpl;
import com.virtusa.validation.UserInput;

/**
 * @Author Manaswini Nalamuthu
 *
 * Number-to-word-converter converts given number within 
 * range 0 to 999,999,999 to English British words
 *
 */
public class App {
	
	public static void main(String[] args) throws InvalidDataException {
		
		ConverterImpl converter = new ConverterImpl();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number : ");
		
		String input = scanner.nextLine();
		UserInput data = new UserInput(input);
		scanner.close();
		// validate input 
		int number = data.validate();

		// convert number to word
		String word = converter.convertToWord(number);
		System.out.println(" British English equvalent of "+number +" is '"+word+"'");
	}
}
