package stacks.queues;

/**
 * 
 * @author tace
 */
/**
 * 
 * How to use a single array to implement three stacks.
 */
public class _1 {

	private static _1StackNode[] buffer = new _1StackNode[300];
	private static int[] stackTopIndex = new int[] { -1, -1, -1 };
	private static int stackCounter = 0;

	public static void main(String[] args) {
		push(0, 10);
		push(0, 20);
		push(0, 30);
		push(1, 110);
		push(2, 210);
		push(1, 120);
		push(2, 220);
		push(1, 130);
		push(2, 230);

		System.out.println(pop(0));
		System.out.println(pop(2));
		System.out.println(pop(1));

		System.out.println(pop(0));
		System.out.println(pop(2));
		System.out.println(pop(1));

		System.out.println(pop(0));
		System.out.println(pop(2));
		System.out.println(pop(1));
	}

	private static void push(int stackNo, int data) {
		buffer[stackCounter] = new _1StackNode(data, stackTopIndex[stackNo]);
		stackTopIndex[stackNo] = stackCounter;
		stackCounter++;
	}

	private static int pop(int stackNo) {
		_1StackNode node = buffer[stackTopIndex[stackNo]];
		stackTopIndex[stackNo] = node.previousIndex;
		stackCounter--;

		return node.data;
	}

	private static int peek(int stackNo) {
		int index = stackTopIndex[stackNo];

		if (index < 0) {
			return index;
		}

		return buffer[index].data;
	}

	static class _1StackNode {

		int data;
		int previousIndex;

		public _1StackNode(int data, int previousIndex) {
			this.data = data;
			this.previousIndex = previousIndex;
		}
	}
}
