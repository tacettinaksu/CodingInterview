package commons;

public class StackNode {

	int data;
	StackNode next;

	public StackNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "" + data;
	}
}
