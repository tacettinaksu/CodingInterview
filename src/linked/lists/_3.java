package linked.lists;

import commons.LinkedListNode;
import commons.LinkedListUtils;

/**
 * 
 * @author tace
 */
/**
 * Implement an algorithm to delete a node in the middle of a single linked
 * list, given only access to that node.
 */
public class _3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = null;
		head = LinkedListUtils.insert(head, 5);
		LinkedListUtils.insert(head, 4);
		LinkedListUtils.insert(head, 3);
		LinkedListUtils.insert(head, 2);
		LinkedListUtils.insert(head, 1);

		LinkedListUtils.printLinkedList(head);

		LinkedListNode removeNode = LinkedListUtils.search(head, 3);
		LinkedListNode previous = null;
		if (removeNode != null) {
			while (removeNode.next != null) {
				int data = removeNode.data;
				removeNode.data = removeNode.next.data;
				removeNode.next.data = data;
				previous = removeNode;
				removeNode = removeNode.next;
			}

			previous.next = null;
		}

		LinkedListUtils.printLinkedList(head);

	}

}
