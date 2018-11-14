package com.virtusa;

import java.util.Scanner;

import com.virtusa.exception.InvalidDataException;
import com.virtusa.services.ConverterImpl;
import com.virtusa.validation.UserInput;

/**
 * @Author Manaswini Nalamuthu
 *
 *  Number-to-word-converter converts given number within range 0 to
 *  999,99964,999 to English British words
 *
 */
public class App {

	public static void main(String[] args) throws InvalidDataException {

		ConverterImpl converter = new ConverterImpl();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number to get equivalent English word : ");

		while (scanner.hasNext()) {
			
			String data = scanner.nextLine();
			UserInput input = new UserInput(data);
			// validate input
			int number = input.validate();

			// convert number to word
			String word = converter.convertToWord(number);
			System.out.println(number + " = " + word);
		}
		scanner.close();
	}
}
