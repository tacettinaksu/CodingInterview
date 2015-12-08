package trees.graphs;

public class _1 {
	public _1() {

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

		System.out.println(bsTree.isBalanced());

		bsTree.insertRecursive(bsTree.root, 2);
		bsTree.insertRecursive(bsTree.root, 1);

		System.out.println(bsTree.isBalanced());
		System.out.println(bsTree.isBalanced());
	}

	public static void main(String[] args) {
		new _1();
	}

	class BSTree {

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

		// TODO implement
		public boolean isBST(BSTNode node) {
			if (node == null) {
				return true;
			}
			int leftVal = node.left.data;
			int current = node.data;
			int rightVal = node.right.data;

			return false;
		}

		public boolean isBalanced() {
			return Math.abs(findMaxDepth(root.left, 0) - findMaxDepth(root.right, 0)) < 2;
		}

		public int findMaxDepth(BSTNode node, int depth) {
			if (node == null)
				return depth;

			int leftDepth = findMaxDepth(node.left, depth + 1);
			int rightDepth = findMaxDepth(node.right, depth + 1);

			return Math.max(leftDepth, rightDepth);
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

		public void inOrder(BSTNode bstNode) {
			if (bstNode == null) {
				return;
			}
			inOrder(bstNode.left);
			System.out.println(bstNode.data);
			inOrder(bstNode.right);
		}
	}

	public class BSTNode {

		int data;
		BSTNode left;
		BSTNode right;

		public BSTNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}