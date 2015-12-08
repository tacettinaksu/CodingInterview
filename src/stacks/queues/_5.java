package stacks.queues;

public class _5 {

	public _5() {
		MyQueue myQueue = new MyQueue();
		for (int i = 1; i <= 10; i++) {
			myQueue.enqueue(i);
		}

		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());

		myQueue.enqueue(11);
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());

		myQueue.enqueue(12);
		myQueue.enqueue(13);
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
	}

	public static void main(String[] args) {
		new _5();
	}

	public class MyQueue {
		private Stack enqueueStack = new Stack();
		private Stack dequeueStack = new Stack();

		public void enqueue(int data) {
			int topData = enqueueStack.pop();

			while (topData >= 0) {
				dequeueStack.push(topData);
				topData = enqueueStack.pop();
			}

			dequeueStack.push(data);
		}

		public int dequeue() {
			int topData = dequeueStack.pop();

			while (topData >= 0) {
				enqueueStack.push(topData);
				topData = dequeueStack.pop();
			}

			return enqueueStack.pop();
		}

	}

	public class Stack {
		StackNode top;

		public int pop() {
			if (top != null) {
				int result = top.data;
				top = top.next;
				return result;
			}

			return -1;
		}

		public void push(int data) {
			StackNode newNode = new StackNode(data);
			newNode.next = top;
			top = newNode;
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
