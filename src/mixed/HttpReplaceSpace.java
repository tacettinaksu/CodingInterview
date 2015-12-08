package mixed;

/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */
/**
 * Write a method to replace all spaces in a string with �%20�.
 */
public class HttpReplaceSpace {

	public static void main(String[] args) {
		String input = "coding interview";
		System.out.println("before : " + input + " after : " + changeSpaces(input));
	}

	private static String changeSpaces(String input) {
		int spaceCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ')
				++spaceCount;
		}

		char[] newString = new char[input.length() + spaceCount * 2];

		for (int i = input.length() - 1, tail = newString.length - 1; i >= 0; i--) {
			if (input.charAt(i) == ' ') {
				newString[tail--] = '0';
				newString[tail--] = '2';
				newString[tail--] = '%';
			} else {
				newString[tail--] = input.charAt(i);
			}

		}
		return String.valueOf(newString);
	}

}
