package commons;

public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {

		// int[] rotatedArray = { 0, 1, 2, 3, 4, 5, 6, 7 };
//		 int[] rotatedArray = { 3, 4, 5, 6, 7, 0, 1, 2 };
		int[] rotatedArray = { 8, 0, 1, 2, 3, 4, 5, 6, 7 };
//		int[] rotatedArray = { 1, 2, 3, 4, 5, 6, 7,0 };

		System.out.println(findMinInRotatedArray(0, rotatedArray.length - 1, rotatedArray));
	}

	public static int findMinInRotatedArray(int minIndex, int maxIndex, int[] rotatedArray) {
		if (rotatedArray[minIndex] > rotatedArray[maxIndex]) {
			int middleIndex = (minIndex + maxIndex) / 2;

			if (rotatedArray[minIndex] > rotatedArray[middleIndex]) {
				return findMinInRotatedArray(minIndex, middleIndex, rotatedArray);
			} else {
				return findMinInRotatedArray(middleIndex + 1, maxIndex, rotatedArray);
			}
		} else {
			return rotatedArray[minIndex];
		}
	}

}
