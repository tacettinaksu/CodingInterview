package arrays.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */
/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */

public class _1 {

	public static void main(String[] args) {

		String input = "codinginterview";

		System.out.println("isAllUnique \"" + input + "\" " + (isAllUnique(input) && isAllUniqueWithoutDataStructures(input)));
	}

	private static boolean isAllUnique(String str) {
		Set<String> lookup = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			String currentChar = String.valueOf(str.charAt(i));
			if (lookup.contains(currentChar)) {
				return false;
			} else {
				lookup.add(currentChar);
			}
		}

		return true;
	}

	/* bad : n^2, use bits for O(n)  */
	private static boolean isAllUniqueWithoutDataStructures(String str) {

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			for (int j = i + 1; j < str.length(); j++) {
				if (currentChar == str.charAt(j)) {
					return false;
				}
			}

		}
		return true;
	}

}
