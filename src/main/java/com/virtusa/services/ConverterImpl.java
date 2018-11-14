package com.virtusa.services;

/**
 * @Author Manaswini Nalamuthu
 *
 *         ConverterImpl class considers group of 3 digits from units place and
 *         gives equivalent English word
 *
 */
public class ConverterImpl implements Converter {

	private static final String units[] = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine", " ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " fifteen", " sixteen", " seventeen",
			" eighteen", " nineteen" };

	private static final String tens[] = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
			" eighty", " ninety" };

	private StringBuilder sb;

	public String convertToWord(int number) {
		sb = new StringBuilder();
		// first three digits equivalent
		formWord(number / 1000000, " million");

		// next three digits equivalent
		formWord((number % 1000000) / 1000, " thousand");

		// last three digits equivalent
		formWord((number % 1000) % 1000, "");

		return sb.toString().trim();
	}

	public void formWord(int n, String s) {
		int x = n / 100;
		if (n > 19) {
			sb.append(units[x]);
		}
		if (x > 0) {
			sb.append(" hundred");
		}
		int x2 = n % 100;

		if (n / 100 > 0 && x2 % 10 > 0) {
			sb.append(" and");
		}
		if (x2 > 19) {
			sb.append(tens[x2 / 10] + units[(n % 10)]);
		} else {
			sb.append(units[x2]);
		}
		if (n > 0)
			sb.append(s);

	}
}
