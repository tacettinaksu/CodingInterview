package commons;

public class MininumumStack {

	StackNode top = null;
	private StackNode minumumTop = null;

	public int pop() {
		if (top == null) {
			return -1;
		}

		if (top.data == minumumTop.data) {
			minumumTop = minumumTop.next;
		}

		StackNode result = top;
		top = top.next;

		return result.data;
	}

	public void push(int data) {
		StackNode newStackNode = new StackNode(data);

		if (top == null || newStackNode.data <= minumumTop.data) {
			StackNode newMin = new StackNode(data);
			newMin.next = minumumTop;
			minumumTop = newMin;
		}

		newStackNode.next = top;
		top = newStackNode;

	}

	public int peek() {
		if (top != null) {
			return top.data;
		}

		return -1;
	}

	public int min() {
		if (minumumTop != null) {
			return minumumTop.data;
		}

		return -1;
	}

}
