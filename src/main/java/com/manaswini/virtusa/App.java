package com.manaswini.virtusa;

import java.util.Scanner;

import com.manaswini.virtusa.exception.InvalidDataException;
import com.manaswini.virtusa.services.Converter;
import com.manaswini.virtusa.services.ConverterImpl;
import com.manaswini.virtusa.validation.UserInput;
import com.manaswini.virtusa.validation.UserInputImpl;

/**
 * @Author Manaswini Nalamuthu
 *
 *  Number-to-word-converter converts given number within range 0 to
 *  999,99964,999 to English British words
 *
 */
public class App {

	public static void main(String[] args) throws InvalidDataException {

		final Converter converter = new ConverterImpl();
		final UserInput input = new UserInputImpl();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number to get equivalent English word : ");

		while (scanner.hasNext()) {
			
			String data = scanner.nextLine();
			// validate input
			int number = input.validate(data);

			// convert number to word
			String word = converter.convertToWord(number);
			System.out.println(number + " = " + word);
		}
		scanner.close();
	}
}
