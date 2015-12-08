package bst.bean;

public class BSTree {

	BSTNode root = null;

	public void insert(int data) {
		BSTNode newNode = new BSTNode(data);

		if (root == null) {
			root = newNode;
			return;
		}

		BSTNode cursor = root;
		while (true) {
			if (cursor == null) {
				cursor = newNode;
				return;
			} else if (data == cursor.data) {
				return;
			} else if (data > cursor.data) {
				if (cursor.right == null) {
					cursor.right = newNode;
					return;
				}
				cursor = cursor.right;
			} else if (data < cursor.data) {
				if (cursor.left == null) {
					cursor.left = newNode;
					return;
				}
				cursor = cursor.left;
			}
		}

	}

	public void insertRecursive(BSTNode node, int data) {

		if (node == null) {
			root = new BSTNode(data);
			return;
		}
		if (node.data == data) {
			return;
		}

		if (node.data > data) {
			if (node.left == null) {
				node.left = new BSTNode(data);
			} else {
				insertRecursive(node.left, data);
			}
		} else {
			if (node.right == null) {
				node.right = new BSTNode(data);
			} else {
				insertRecursive(node.right, data);
			}
		}

	}

	public void delete(int data) {
		BSTNode nodeToDelete = root;
		BSTNode parent = null;

		while (nodeToDelete != null) {
			if (nodeToDelete.data == data) {
				break;
			} else if (nodeToDelete.data > data) {
				parent = nodeToDelete;
				nodeToDelete = nodeToDelete.left;
			} else {
				parent = nodeToDelete;
				nodeToDelete = nodeToDelete.right;
			}
		}

		if (nodeToDelete == null) {
			System.out.println("Value " + data + "does not exist in tree");
			return;
		}

		if (parent == null) {
			root = null;
		} else if (nodeToDelete.right == null && nodeToDelete.left == null) {
			if (parent.data > nodeToDelete.data) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (nodeToDelete.right == null) {
			nodeToDelete.data = nodeToDelete.left.data;
			nodeToDelete.left = null;
		} else if (nodeToDelete.left == null) {
			nodeToDelete.data = nodeToDelete.right.data;
			nodeToDelete.right = null;
		} else {
			BSTNode nextMax = nodeToDelete.right;

			while (nextMax.left != null) {
				nextMax = nextMax.left;
			}

			nodeToDelete.data = nextMax.left.data;
			nextMax.left = null;
		}

	}

	public void inOrder(BSTNode bstNode) {
		if (bstNode == null) {
			return;
		}
		inOrder(bstNode.left);
		System.out.println(bstNode.data);
		inOrder(bstNode.right);
	}

	public static void main(String args[]) {
		BSTree bsTree = new BSTree();
		bsTree.inOrder(bsTree.root);

		bsTree.insertRecursive(bsTree.root, 20);
		bsTree.insertRecursive(bsTree.root, 10);
		bsTree.insertRecursive(bsTree.root, 30);
		bsTree.insertRecursive(bsTree.root, 5);
		bsTree.insertRecursive(bsTree.root, 15);
		bsTree.insertRecursive(bsTree.root, 25);
		bsTree.insertRecursive(bsTree.root, 35);
		bsTree.insertRecursive(bsTree.root, 3);
		bsTree.insertRecursive(bsTree.root, 7);
		bsTree.insertRecursive(bsTree.root, 12);
		bsTree.insertRecursive(bsTree.root, 18);
		bsTree.insertRecursive(bsTree.root, 23);
		bsTree.insertRecursive(bsTree.root, 28);
		bsTree.insertRecursive(bsTree.root, 33);
		bsTree.insertRecursive(bsTree.root, 40);
		bsTree.insertRecursive(bsTree.root, 11);
		bsTree.inOrder(bsTree.root);

	}
	/*
	 * public static void main(String args[]) { BSTree bsTree = new BSTree();
	 * bsTree.inOrder(bsTree.root);
	 * 
	 * bsTree.insert(20); bsTree.insert(10); bsTree.insert(30);
	 * bsTree.insert(5); bsTree.insert(15); bsTree.insert(25);
	 * bsTree.insert(35); bsTree.insert(3); bsTree.insert(7); bsTree.insert(12);
	 * bsTree.insert(18); bsTree.insert(23); bsTree.insert(28);
	 * bsTree.insert(33); bsTree.insert(40); bsTree.insert(11);
	 * bsTree.inOrder(bsTree.root); }
	 */
}
