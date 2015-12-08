package linked.lists;

import commons.LinkedListNode;
import commons.LinkedListUtils;

/**
 * 
 * @author tace
 */
/**
 * You have two numbers represented by a linked list, where each node contains a
 * sin- gle digit. The digits are stored in reverse order, such that the 1’s
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 */
public class _4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head1 = null;
		head1 = LinkedListUtils.insert(head1, 3);
		LinkedListUtils.insert(head1, 1);
		LinkedListUtils.insert(head1, 5);

		LinkedListNode head2 = null;
		head2 = LinkedListUtils.insert(head2, 5);
		LinkedListUtils.insert(head2, 9);
		LinkedListUtils.insert(head2, 9);

		LinkedListUtils.printLinkedList(head1);
		LinkedListUtils.printLinkedList(head2);

		LinkedListNode sum = null;
		int incremantal = 0;
		while (head1 != null && head2 != null) {
			int total = head1.data + head2.data + incremantal;
			incremantal = total / 10;
			sum = LinkedListUtils.insert(sum, total % 10);

			head1 = head1.next;
			head2 = head2.next;
		}

		if (incremantal > 0) {
			sum = LinkedListUtils.insert(sum, incremantal);
		}
		LinkedListUtils.printLinkedList(sum);
	}

}
