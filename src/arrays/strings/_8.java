package arrays.strings;

/**
 * 
 * @author tace
 * @since Aug 16, 2015
 */
/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (i.e., �waterbottle� is a
 * rotation of �erbottlewat�).
 */

public class _8 {

	public static void main(String[] args) {
		String input = "waterbottle";
		String rotated = "erbottlewat";
		System.out.println("isRotation :" + input + "," + rotated + " : " + isRotation(input, rotated));
	}

	private static boolean isRotation(String input, String rotated) {
		return false;
	}

}
