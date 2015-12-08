package stacks.queues;

import commons.MininumumStack;

/**
 * 
 * @author tace
 */
/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 */
public class _2 {

	public static void main(String[] args) {
		MininumumStack stack = new MininumumStack();

		stack.push(3);
		stack.push(7);
		stack.push(3);
		stack.push(1);

		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());
	}
}
