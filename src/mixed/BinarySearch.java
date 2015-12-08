package mixed;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		int arrSize = in.nextInt();
		int[] array = new int[arrSize];

		for (int i = 0; i < array.length; i++) {
			array[i] = in.nextInt();
		}

		System.out.println(searchValue(0, arrSize - 1, value, array));

	}

	private static int searchValue(int minIndex, int maxIndex, int value,
			int[] array) {
		int middle = (minIndex + maxIndex) / 2;

		if (array[middle] == value) {
			return middle;
		} else if (array[middle] > value) {
			return searchValue(minIndex, middle-1, value, array);
		} else {
			return searchValue(middle+1, maxIndex, value, array);
		}

	}
}