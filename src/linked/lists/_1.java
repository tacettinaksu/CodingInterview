package linked.lists;

import commons.LinkedListNode;
import commons.LinkedListUtils;

/**
 * 
 * @author tace
 */
/**
 * Write code to insert unique to a list
 */
public class _1 {

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
		LinkedListUtils.insert(head, 3);
		LinkedListUtils.insert(head, 4);
		LinkedListUtils.insert(head, 1);
		LinkedListUtils.insert(head, 3);
		LinkedListUtils.insert(head, 2);
		LinkedListUtils.insert(head, 1);

		LinkedListUtils.printLinkedList(head);

		LinkedListNode cursor = head;
		LinkedListNode newHead = null;
		while (cursor != null) {
			newHead = LinkedListUtils.insertUniqe(newHead, cursor.data);
			cursor = cursor.next;
		}

		LinkedListUtils.printLinkedList(newHead);
	}

}
