package trees.graphs;

import java.util.Stack;

public class _6 {
	public _6() {

		BSTree bsTree = new BSTree();
		// L1
		bsTree.root = new BSTNode(1);

		// L2
		bsTree.root.left = new BSTNode(2);
		bsTree.root.right = new BSTNode(3);

		// L3
		bsTree.root.left.left = new BSTNode(6);
		bsTree.root.left.right = new BSTNode(8);
		bsTree.root.right.left = new BSTNode(7);
		bsTree.root.right.right = new BSTNode(18);

		// L3
		bsTree.root.left.left.left = new BSTNode(16);
		bsTree.root.left.left.right = new BSTNode(9);

		bsTree.root.left.right.left = new BSTNode(4);
		bsTree.root.left.right.right = new BSTNode(10);

		bsTree.root.right.left.left = new BSTNode(5);
		bsTree.root.right.left.right = new BSTNode(11);

		bsTree.root.right.right.left = new BSTNode(7);
		bsTree.root.right.right.right = new BSTNode(14);

		// L4
		bsTree.root.left.right.left.left = new BSTNode(19);

		System.out.println(bsTree.findCommonParentInNonBST(14, 10));
		System.out.println(bsTree.findCommonParentInNonBST(19, 10));
		System.out.println(bsTree.findCommonParentInNonBST(19, 16));

	}

	public static void main(String[] args) {
		new _6();
	}

	class BSTree {

		BSTNode root = null;

		public int findCommonParentInNonBST(int input1, int input2) {
			System.out.println();
			System.out.println("Looking for common parent node for " + input1 + " and " + input2);
			Stack<BSTNode> nodes = new Stack<>();
			findPath(input1, nodes, root, false);

			Stack<BSTNode> nodes2 = new Stack<>();
			findPath(input2, nodes2, root, false);

			if (nodes.isEmpty() || nodes2.isEmpty()) {
				return -1;
			}

			while (nodes.size() != nodes2.size()) {
				if (nodes.size() > nodes2.size()) {
					nodes.pop();
				} else {
					nodes2.pop();
				}
			}

			BSTNode result = null;
			while (nodes.peek() != nodes2.peek()) {
				nodes.pop();
				nodes2.pop();
			}

			result = nodes.pop();

			if (result != null) {
				return result.data;
			}
			return -1;
		}

		private void findPath(int input1, Stack<BSTNode> nodes, BSTNode node, boolean found) {
			nodes.push(node);

			if (node == null) {
				return;
			}

			if (!nodes.isEmpty() && nodes.peek().data == input1)
				return;

			findPath(input1, nodes, node.left, found);
			if (!nodes.isEmpty() && nodes.peek() != null && nodes.peek().data == input1) {
				return;
			}
			nodes.pop();

			findPath(input1, nodes, node.right, found);
			if (!nodes.isEmpty() && nodes.peek() != null && nodes.peek().data == input1)
				return;
			nodes.pop();

		}

		public int findCommonParentInBST(int input1, int input2) {
			if (input1 == input2) {
				return input1;
			}

			int small, big;

			if (input1 > input2) {
				small = input2;
				big = input1;
			} else {
				small = input1;
				big = input2;
			}

			BSTNode temp = root;

			while (temp != null) {
				if (small <= temp.data && big >= temp.data) {
					break;
				}

				if (temp.data > small && temp.data > big) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			return temp == null ? -1 : temp.data;
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