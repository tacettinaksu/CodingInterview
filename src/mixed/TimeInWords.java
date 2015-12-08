package mixed;

import java.util.Scanner;

public class TimeInWords {

	public static final String[] units = { "", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
			"sixteen", "seventeen", "eighteen", "nineteen" };
	public static final String[] tens = { "", // 0
			"", // 1
			"twenty", // 2
			"thirty", // 3
			"forty", // 4
			"fifty", // 5
			"sixty", // 6
			"seventy", // 7
			"eighty", // 8
			"ninety" // 9
	};

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int M = in.nextInt();

		if (H < 1 || H > 12 || M < 0 || M > 59) {
			System.out.println("ERROR");
		}

		if (M == 0) {
			System.out.println(getDigitString(H) + " o' clock");
		} else if (M == 15) {
			System.out.println("quarter past " + getDigitString(H));
		} else if (M == 45) {
			System.out.println("quarter to " + getDigitString(H + 1));
		} else if (M == 30) {
			System.out.println("half past " + getDigitString(H));
		} else if (M < 30) {
			System.out.println(getDigitString(M) + " minute" + (M > 1 ? "s " : " ") + "past "
					+ getDigitString(H));
		} else if (M > 30) {
			int toValue = 60 - M;
			System.out.println(getDigitString(toValue) + " minute" + (toValue > 1 ? "s " : " ")
					+ "to " + getDigitString(H + 1));
		} else {
			System.out.println("ERROR");
		}

	}

	private static String getDigitString(int digit) {
		if (digit < 20 && digit > 0) {
			return units[digit];
		}

		String first = tens[digit / 10];
		String second = units[digit % 10];
		String middle = "";
		if (first.length() > 0 && second.length() > 0) {
			middle = " ";
		}

		return first + middle + second;
	}
}