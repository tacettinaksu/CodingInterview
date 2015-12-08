package trees.graphs;

public class _3 {
	public _3() {

		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15 };
		BSTree tree = new BSTree();
		insertBalanced(tree, array, 0, array.length - 1);

		System.out.println(tree.findMaxDepth(tree.root, 0));

	}

	public void insertBalanced(BSTree tree, int[] array, int lowerBound, int upperBound) {
		int middleElement = (lowerBound + upperBound) / 2;
		tree.insert(array[middleElement]);

		if (Math.abs(upperBound - lowerBound) < 2) {
			tree.insert(array[upperBound]);
		} else {
			insertBalanced(tree, array, lowerBound, middleElement - 1);
			insertBalanced(tree, array, middleElement + 1, upperBound);
		}
	}

	public static void main(String[] args) {
		new _3();
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

		public int findMaxDepth(BSTNode node, int depth) {
			if (node == null)
				return depth;

			int leftDepth = findMaxDepth(node.left, depth + 1);
			int rightDepth = findMaxDepth(node.right, depth + 1);

			return Math.max(leftDepth, rightDepth);
		}

		public void insert(BSTNode node, int data) {
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
					insert(node.left, data);
				}
			} else {
				if (node.right == null) {
					node.right = new BSTNode(data);
				} else {
					insert(node.right, data);
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