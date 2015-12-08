package arrays.strings;

/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */
/**
 * Write a method to decide if two strings are anagrams or not
 */
public class _4 {

	public static void main(String[] args) {
		System.out.println(isAnagram("coding", "cgnido"));
		System.out.println(isAnagram("interview", "eiirntwew"));
	}

	private static boolean isAnagram(String input1, String input2) {
		System.out.print ("is "+input1 +" and "+ input2 +" anagram : ");
		if (input1 == null && input2 == null) {
			return true;
		}

		if (input1.length() != input2.length()) {
			return false;
		}

		char[] lookup = new char[256];

		for (int i = 0; i < lookup.length; i++) {
			lookup[i] = 0;
		}

		for (int i = 0; i < input1.length(); i++) {
			lookup[input1.charAt(i)] += 1;
			lookup[input2.charAt(i)] -= 1;
		}

		int sum = 0;
		for (int i = 0; i < lookup.length; i++) {
			sum += lookup[i];
		}

		return sum == 0;
	}
}
