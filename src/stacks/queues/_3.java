package stacks.queues;

import commons.SetStack;

/**
 * 
 * @author tace
 */

public class _3 {

	public static void main(String[] args) {
		SetStack stack = new SetStack();

		stack.push(3);
		stack.push(7);
		stack.push(3);
		stack.push(1);

		System.out.println("data : " + stack.pop() + "  size:" + stack.topSetStack.stackSize);
		System.out.println("data : " + stack.pop() + "  size:" + stack.topSetStack.stackSize);
		System.out.println("data : " + stack.pop() + "  size:" + stack.topSetStack.stackSize);
		System.out.println("data : " + stack.pop() + "  size:" + stack.topSetStack.stackSize);

	}
}
