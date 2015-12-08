package arrays.strings;
/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */

/**
 * Write code to reverse a C-Style String. (C-String means that “abcd” is
 * represented as five characters, including the null character.)
 */
public class _2 {

	public static void main(String[] args) {
		System.out.println("abcde -> " + reverseCString("abcde"));
		System.out.println("->" + reverseCString(""));
	}

	private static String reverseCString(String input) {
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

		return String.valueOf(arr);
	}

}
