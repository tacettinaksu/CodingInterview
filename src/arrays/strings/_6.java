package arrays.strings;

import cci.commons.Utils;

/**
 * 
 * @author tace
 * @since Aug 8, 2015
 */
/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 */
public class _6 {

	public static void main(String[] args) {

		long[][] input = {	{ 0, 1, 2, 3, 4 },
							{ 5, 6, 7, 8, 9 },
							{ 10, 11, 12, 13, 14 },
							{ 15, 16, 17, 18, 19 },
							{ 20, 21, 22, 23, 24 }
						};
		System.out.println("before :");
		Utils.printArray(input);
		System.out.println("after :");
		Utils.printArray(rotate(input));
	}

	private static long[][] rotate(long[][] array) {
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			int lowBound = i;
			int highBound = n - 1 - i;

			for (int j = 0; j < highBound - lowBound; j++) {
				long temp1 = array[lowBound + j][highBound];
				array[lowBound + j][highBound] = array[lowBound][lowBound + j];
				long temp2 = array[highBound][highBound - j];
				array[highBound][highBound - j] = temp1;
				temp1 = array[highBound - j][lowBound];
				array[highBound - j][lowBound] = temp2;
				array[lowBound][lowBound + j] = temp1;
			}
		}

		return array;
	}

}
