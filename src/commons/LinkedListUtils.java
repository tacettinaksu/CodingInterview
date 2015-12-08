package commons;

public class LinkedListUtils {

	public static LinkedListNode insert(LinkedListNode head, int data) {
		if (head == null) {
			return new LinkedListNode(data);
		}
		LinkedListNode cursor = head;
		while (cursor.next != null) {
			cursor = cursor.next;
		}

		cursor.next = new LinkedListNode(data);

		return head;
	}

	public static LinkedListNode search(LinkedListNode head, int data) {

		LinkedListNode cursor = head;
		while (cursor != null) {
			if (cursor.data == data) {
				return cursor;
			}
			cursor = cursor.next;
		}

		return null;
	}

	public static LinkedListNode insertUniqe(LinkedListNode head, int data) {
		if (head == null) {
			return new LinkedListNode(data);
		}
		LinkedListNode cursor = head;

		if (cursor.data == data) {
			return head;
		}

		while (cursor.next != null) {
			if (cursor.next.data == data) {
				return head;
			}
			cursor = cursor.next;
		}

		cursor.next = new LinkedListNode(data);

		return head;
	}

	public static LinkedListNode insertSorted(LinkedListNode head, int data) {
		LinkedListNode newData = new LinkedListNode(data);

		if (head == null) {
			return newData;
		}

		LinkedListNode cursor = head;

		if (head.data > newData.data) {
			newData.next = head;
			head = newData;
			return head;
		}

		while (cursor.next != null && cursor.next.data <= data) {
			cursor = cursor.next;
		}

		newData.next = cursor.next;
		cursor.next = newData;

		return head;
	}

	public static LinkedListNode insertSortedUnique(LinkedListNode head, int data) {
		LinkedListNode newData = new LinkedListNode(data);

		if (head == null) {
			return newData;
		} else if (head.data == data) {
			return head;
		}

		LinkedListNode cursor = head;

		if (head.data > newData.data) {
			newData.next = head;
			head = newData;
			return head;
		}

		while (cursor.next != null && cursor.next.data <= data) {
			if (cursor.data == data || cursor.next.data == data) {
				return head;
			}

			cursor = cursor.next;
		}
		newData.next = cursor.next;
		cursor.next = newData;

		return head;
	}

	public static void main(String args[]) {
		// testNormalInsert();
		// testSortedInsert();
		// testSortedUniqueInsert();
		testUniqueInsert();
	}

	private static void testSortedInsert() {
		LinkedListNode head = null;
		printLinkedList(head);

		head = insertSorted(head, 1);
		head = insertSorted(head, 3);
		printLinkedList(head);

		head = insertSorted(head, 2);
		printLinkedList(head);

		head = insertSorted(head, 7);
		printLinkedList(head);

		head = insertSorted(head, 7);
		printLinkedList(head);

		head = insertSorted(head, 6);
		printLinkedList(head);

		head = insertSorted(head, 8);
		printLinkedList(head);

		head = insertSorted(head, 0);
		printLinkedList(head);
	}

	private static void testSortedUniqueInsert() {
		LinkedListNode head = null;
		printLinkedList(head);

		head = insertSortedUnique(head, 1);
		head = insertSortedUnique(head, 3);
		printLinkedList(head);

		head = insertSortedUnique(head, 2);
		printLinkedList(head);

		head = insertSortedUnique(head, 7);
		printLinkedList(head);

		head = insertSortedUnique(head, 7);
		printLinkedList(head);

		head = insertSortedUnique(head, 6);
		printLinkedList(head);

		head = insertSortedUnique(head, 8);
		printLinkedList(head);

		head = insertSortedUnique(head, 0);
		printLinkedList(head);

		head = insertSortedUnique(head, 0);
		printLinkedList(head);

		head = insertSortedUnique(head, 1);
		printLinkedList(head);

	}

	private static void testNormalInsert() {
		LinkedListNode head = null;
		printLinkedList(head);

		head = insert(head, 5);
		printLinkedList(head);

		insert(head, 4);
		insert(head, 3);
		insert(head, 2);
		insert(head, 1);
		printLinkedList(head);
	}

	private static void testUniqueInsert() {
		LinkedListNode head = null;
		printLinkedList(head);

		head = insertUniqe(head, 5);
		printLinkedList(head);

		insertUniqe(head, 4);
		insertUniqe(head, 3);
		insertUniqe(head, 2);
		insertUniqe(head, 1);
		printLinkedList(head);

		insertUniqe(head, 4);
		insertUniqe(head, 3);
		insertUniqe(head, 2);
		insertUniqe(head, 1);
		printLinkedList(head);
	}

	public static void printLinkedList(LinkedListNode head) {
		System.out.print("->");
		while (head != null) {
			System.out.print("{" + head.data + "} ->");
			head = head.next;
		}

		System.out.println();
	}
}
