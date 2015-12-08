package arrays.strings;

import cci.commons.Utils;

/**
 * 
 * @author tace
 * @since Aug 16, 2015
 */

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 */
public class _7 {

	public static void main(String[] args) {

		long[][] input = { { 0, 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11, 0, 13, 14 }, { 15, 16, 17, 18, 19 }, { 20, 21, 22, 23, 0 } };
		System.out.println("before :");
		Utils.printArray(input);
		System.out.println("after :");
		Utils.printArray(edit(input));
	}

	private static long[][] edit(long[][] array) {
		boolean[] rows = new boolean[array.length];
		boolean[] cols = new boolean[array.length];

		for (int i = 0; i < cols.length; i++) {
			rows[i] = false;
			cols[i] = false;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int i = 0; i < cols.length; i++) {
			if (cols[i]) {
				for (int j = 0; j < array.length; j++) {
					array[j][i] = 0;
				}
			}
			if (rows[i]) {
				for (int j = 0; j < array.length; j++) {
					array[i][j] = 0;
				}
			}
		}

		return array;
	}

}
