package recursion;

public class _2 {

	/**
	 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The
	 * robot can only move in two directions: right and down. How many possible
	 * paths are there for the robot? FOLLOW UP Imagine certain squares are “off
	 * limits”, such that the robot can not step on them. Design an algorithm to
	 * get all possible paths for the robot.
	 */
	public _2() {

		System.err.println(possiblePathCount(2, 0, 0));
		System.err.println(possiblePathCount(3, 0, 0));
	}

	public int possiblePathCount(int n, int i, int j) {
		if (i >= n || j >= n)
			return 0;
		
		if(i == n-1 && j == n-1){
			return 1;
		}
		return possiblePathCount(n, i + 1, j) + possiblePathCount(n, i, j + 1);
	}

	public static void main(String[] args) {
		new _2();
	}

}
