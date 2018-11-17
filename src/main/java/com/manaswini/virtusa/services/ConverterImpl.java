package com.manaswini.virtusa.services;

import com.manaswini.virtusa.exception.InvalidDataException;
import com.manaswini.virtusa.util.ConverterHelper;

/**
 * @Author Manaswini Nalamuthu
 *
 *         ConverterImpl class splits input to group of 3 digits from units place and
 *         gives equivalent English word
 *
 */
public class ConverterImpl implements Converter {

	private final ConverterHelper helper = new ConverterHelper();

	public String convertToWord(int number) throws InvalidDataException {
		StringBuilder englishWord = new StringBuilder();

		if (number == 0) {
			englishWord.append("zero");

		} else {
			// first three digits equivalent
			englishWord.append(formThreeDigitEquiWord(number / 1000000, 0, englishWord));

			// next three digits equivalent
			englishWord.append(formThreeDigitEquiWord((number % 1000000) / 1000, 1, englishWord));

			// last three digits equivalent
			englishWord.append(formThreeDigitEquiWord((number % 1000) % 1000, 3, englishWord));
		}
		return englishWord.toString().trim();
	}

	public String formThreeDigitEquiWord(int num, int place, StringBuilder englishWord) throws InvalidDataException {
		StringBuilder threeDigitEquiWord = new StringBuilder();
		String hundredthPlaceWord;
		
		try {
			hundredthPlaceWord = formHundredthPlaceWord(num);
			if (hundredthPlaceWord.length() > 0) {
				threeDigitEquiWord.append(hundredthPlaceWord);
				threeDigitEquiWord.append(helper.appendAND(num % 100, englishWord, threeDigitEquiWord));
			}
			threeDigitEquiWord.append(formUnitsTensDigitsWord(num % 100));
			if (threeDigitEquiWord.length() > 0) {

				threeDigitEquiWord.append(helper.higherPlace[place]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidDataException("Input should be less than 1000");
		}
		return threeDigitEquiWord.toString();
	}

	public String formHundredthPlaceWord(int n) {
		StringBuilder threeDigitWord = new StringBuilder();

		int x = n / 100;
		if (n > 19) {
			threeDigitWord.append(helper.units[x]);
		}
		if (x > 0) {
			threeDigitWord.append(helper.higherPlace[2]);
		}

		return threeDigitWord.toString();

	}

	public String formUnitsTensDigitsWord(int n) throws InvalidDataException {
		StringBuilder lastTwoDigitsWords = new StringBuilder();
		try {
			if (n > 19) {
				lastTwoDigitsWords.append(helper.tens[n / 10] + helper.units[(n % 10)]);
			} else {
				lastTwoDigitsWords.append(helper.units[n]);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidDataException("Input should be less than 100");
		}
		return lastTwoDigitsWords.toString();
	}
}
