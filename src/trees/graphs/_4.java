package trees.graphs;

import java.util.ArrayList;
import java.util.List;

public class _4 {
	public _4() {

		BSTree tree = new BSTree();
		// LEVEL1
		tree.insert(15);

		// LEVEL2
		tree.insert(20);
		tree.insert(10);

		// LEVEL3
		tree.insert(9);
		tree.insert(11);
		tree.insert(21);
		// LEVEL4
		tree.insert(8);
		// LEVEL5
		tree.insert(7);

		List<List<BSTNode>> lists = new ArrayList<List<BSTNode>>();
		treeToLists(tree.root, 0, lists);

		int i=0;
		for (List<BSTNode> list : lists) {
			System.out.println(i++);
			for (BSTNode bstNode : list) {
				System.out.print(bstNode.data + " ");
			}
			System.out.println();
		}

	}

	private void treeToLists(BSTNode node, int depth, List<List<BSTNode>> lists) {
		if (node == null) {
			return;
		}

		if (depth >= lists.size()) {
			lists.add(depth, new ArrayList<_4.BSTNode>());
		}
		lists.get(depth).add(node);

		treeToLists(node.left, depth + 1, lists);
		treeToLists(node.right, depth + 1, lists);

	}

	public static void main(String[] args) {
		new _4();
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