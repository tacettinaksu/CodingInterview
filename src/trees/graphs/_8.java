package trees.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tace
 * @since Jul 4, 2015
 */

public class _8 {

	/**
	 * You are given a binary tree in which each node contains a value. Design
	 * an algorithm to print all paths which sum up to that value. Note that it
	 * can be any path in the tree - it does not have to start at the root.
	 */
	public _8() {

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

		bsTree.printPathWithSum(24);
		bsTree.printPathWithSum(18);
		bsTree.printPathWithSum(16);
		bsTree.printPathWithSum(32);
		bsTree.printPathWithSum(35);
		bsTree.printPathWithSum(15);
	}

	public static void main(String[] args) {
		new _8();
	}

	class BSTree {

		BSTNode root = null;

		public void printPathWithSum(int sum) {
			List<BSTNode> nodes = new ArrayList<>();
			getPathWithSum(root, nodes, sum);

			System.out.println("Path for "+sum+" : ");
			for (BSTNode bstNode : nodes) {
				System.out.print(bstNode.data + " -> ");
			}
			System.out.println();
			System.out.println();
		}

		private void getPathWithSum(BSTNode node, List<BSTNode> nodes, int sum) {
			if (node == null) {
				return;
			}
			nodes.add(node);
			if (node.isLeaf() && isListExistWithSum(sum, nodes)) {
				extractListWithSum(sum, nodes);
				return;
			}
			getPathWithSum(node.left, nodes, sum);
			if (isListExistWithSum(sum, nodes)) {
				extractListWithSum(sum, nodes);
				return;
			}
			nodes.remove(node.left);
			getPathWithSum(node.right, nodes, sum);
			if (isListExistWithSum(sum, nodes)) {
				extractListWithSum(sum, nodes);
				return;
			}
			nodes.remove(node.right);
		}

		private boolean isListExistWithSum(int sum, List<BSTNode> nodes) {
			int currentSum = 0;
			for (int i = nodes.size() - 1; i >= 0 && currentSum < sum; i--) {
				currentSum += nodes.get(i).data;
				if (currentSum == sum) {
					return true;
				}
			}

			return false;
		}

		private List<BSTNode> extractListWithSum(int sum, List<BSTNode> nodes) {
			int currentSum = 0;
			for (int i = nodes.size() - 1; i >= 0; i--) {
				currentSum += nodes.get(i).data;
				if (currentSum == sum) {
					for (i = i - 1; i >= 0; i--) {
						nodes.remove(0);
					}
					return nodes;
				}
			}

			return null;
		}

		public void inOrder() {
			inOrder(root);
		}

		private void inOrder(BSTNode bstNode) {
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

		public boolean isLeaf() {
			return left == null && right == null;
		}
	}

}