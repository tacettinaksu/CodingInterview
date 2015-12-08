package stacks.queues;

public class _6 {

	public _6() {
		Stack stack = new Stack();
		stack.push(0);
		stack.push(6);
		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(9);
		stack.push(3);
		stack.push(3);
		stack.push(1);

		System.out.println(stack);

		stack.sort();
		System.out.println(stack);

	}

	public static void main(String[] args) {
		new _6();
	}

	public class Stack {
		StackNode top;

		public void sort() {
			boolean isSorted = false;

			while (!isSorted) {
				StackNode cursor = top;
				isSorted = true;
				while (cursor != null && cursor.next != null) {
					if (cursor.data > cursor.next.data) {
						int tempData = cursor.next.data;
						cursor.next.data = cursor.data;
						cursor.data = tempData;
						isSorted = false;
					}
					cursor = cursor.next;
				}
			}
		}

		public int pop() {
			if (!isEmpty()) {
				int result = top.data;
				top = top.next;
				return result;
			}

			return -1;
		}

		public int peek() {
			if (!isEmpty()) {
				return top.data;
			}

			return -1;
		}

		public void push(int data) {
			StackNode newNode = new StackNode(data);
			newNode.next = top;
			top = newNode;
		}

		public boolean isEmpty() {
			return top == null;
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
