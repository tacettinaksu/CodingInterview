package stacks.queues;

public class _4 {

	public static int counter = 0;

	public _4() {
		int diskSize = 30;
		Stack from = new Stack();
		Stack using = new Stack();
		Stack to = new Stack();

		for (int i = diskSize; i > 0; i--) {
			from.push(i);
		}

		System.out.println("from : " + from);
		System.out.println("to : " + using);
		System.out.println("using : " + to);

		long start = System.currentTimeMillis();
		hanoi(diskSize, from, using, to);
		long end = System.currentTimeMillis();
		
		System.out.println("from : " + from);
		System.out.println("to : " + using);
		System.out.println("using : " + to);
		System.out.println("time : " + (end - start) / 1000 + " second(s)");
		System.out.println("move count : " + counter);
	}

	public static void main(String[] args) {
		new _4();
	}

	public void hanoi(int N, Stack from, Stack using, Stack to) {
		if (N > 0) {
			hanoi(N - 1, from, to, using);

			to.push(from.pop());
			counter++;

			hanoi(N - 1, using, from, to);
		}
	}

	public class Stack {
		StackNode top;

		public int pop() {
			int result = top.data;
			top = top.next;
			return result;
		}

		public void push(int data) {
			StackNode newNode = new StackNode(data);
			if (top == null || top.data > newNode.data) {
				newNode.next = top;
				top = newNode;
			} else {
				throw new RuntimeException(data + " can not come on top of " + top.data);
			}
		}

		@Override
		public String toString() {
			StackNode temp = top;
			StringBuffer result = new StringBuffer();
			while (temp != null) {
				result.append(temp.data + "-> ");
				temp = temp.next;
			}

			return result.toString();
		}
	}

	class StackNode {
		int data;
		StackNode next;

		public StackNode(int data) {
			this.data = data;
			next = null;
		}
	}
}
