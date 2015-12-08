package commons;

public class Utils {

	public static void printArray(long[][] input) {
		System.out.println();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
