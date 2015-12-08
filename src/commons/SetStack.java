package commons;

public class SetStack {

	public SetStackNode topSetStack = null;

	public void push(int data) {
		if (topSetStack == null) {
			topSetStack = new SetStackNode();
		}

		StackNode newNode = new StackNode(data);
		if (topSetStack.topStackNode == null) {
			topSetStack.topStackNode = newNode;
			topSetStack.stackSize++;
		} else {
			StackNode node = newNode;
			node.next = topSetStack.topStackNode;
			topSetStack.topStackNode = node;
			topSetStack.stackSize++;
		}
	}

	public int pop() {
		int data = topSetStack.topStackNode.data;

		topSetStack.topStackNode = topSetStack.topStackNode.next;
		topSetStack.stackSize--;

		return data;
	}
}
