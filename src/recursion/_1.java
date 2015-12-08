package recursion;

public class _1 {

	/**
	 * Write a method to generate the nth Fibonacci number.
	 */
	public _1() {

		System.err.println(fibonacci(10));
	}

	public int fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		new _1();
	}

}
