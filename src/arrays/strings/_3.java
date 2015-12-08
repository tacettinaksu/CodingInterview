package arrays.strings;

/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */
/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not.
 */
public class _3 {

	public static void main(String[] args) {
		String input = "codinginterview";
		System.out.println("Before: " + input + " after: " + removeDuplicateCharacters(input));
	}

	private static String removeDuplicateCharacters(String input) {
		long checker = 0;

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			current -= 'a';

			if ((checker & (1 << current)) > 0) {
				input = input.substring(0, i) + input.substring(i + 1, input.length());
				--i;
			} else {
				checker |= (1 << current);
			}
		}
		return input;
	}
}
