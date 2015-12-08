package linked.lists;

import commons.LinkedListNode;

/**
 * 
 * @author tace
 */
/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the begin- ning of the loop.
 *
 */
public class _5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create sample

		LinkedListNode node0 = new LinkedListNode(0);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(5);
		LinkedListNode node6 = new LinkedListNode(6);
		LinkedListNode node7 = new LinkedListNode(7);
		LinkedListNode node8 = new LinkedListNode(8);
		LinkedListNode node9 = new LinkedListNode(9);
		LinkedListNode node10 = new LinkedListNode(10);
		LinkedListNode node11 = new LinkedListNode(11);
		LinkedListNode node12 = new LinkedListNode(12);
		LinkedListNode node13 = new LinkedListNode(13);
		LinkedListNode node14 = new LinkedListNode(14);
		LinkedListNode node15 = new LinkedListNode(15);

		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node7;

		LinkedListNode head = node0;
		LinkedListNode tortoise = node0.next;
		LinkedListNode hare = node0.next.next;

		while (tortoise != hare) {
			tortoise = tortoise.next;
			hare = hare.next.next;
		}

		System.out.println("First meet : " + tortoise.data);

		while (head != tortoise) {
			head = head.next;
			tortoise = tortoise.next;
		}
		System.out.println("Start of cycle : " + tortoise.data);

	}

}
