package trees.graphs;

/**
 * 
 * @author tace
 * @since Jul 4, 2015
 */

public class _7 {

	/**
	 * TODO not working
	 */
	/**
	 * You have two very large binary trees: T1, with millions of nodes, and T2,
	 * with hun- dreds of nodes. Create an algorithm to decide if T2 is a
	 * subtree of T1.
	 */
	public _7() {

		BSTree bsTreeMain = new BSTree();
		// L1
		bsTreeMain.root = new BSTNode(1);

		// L2
		bsTreeMain.root.left = new BSTNode(2);
		bsTreeMain.root.right = new BSTNode(3);

		// L3
		bsTreeMain.root.left.left = new BSTNode(6);
		bsTreeMain.root.left.right = new BSTNode(8);

		bsTreeMain.root.right.left = new BSTNode(7);
		bsTreeMain.root.right.right = new BSTNode(18);

		// L4
		bsTreeMain.root.left.left.left = new BSTNode(16);
		bsTreeMain.root.left.left.right = new BSTNode(9);

		bsTreeMain.root.left.right.left = new BSTNode(4);
		bsTreeMain.root.left.right.right = new BSTNode(10);

		bsTreeMain.root.right.left.left = new BSTNode(5);
		bsTreeMain.root.right.left.right = new BSTNode(11);

		bsTreeMain.root.right.right.left = new BSTNode(7);
		bsTreeMain.root.right.right.right = new BSTNode(14);

		// L5
		bsTreeMain.root.left.right.left.left = new BSTNode(19);

		BSTree bsTreeInner = new BSTree();
		// L1
		bsTreeInner.root = new BSTNode(2);

		// L2
		bsTreeInner.root.left = new BSTNode(6);
		bsTreeInner.root.right = new BSTNode(8);

		bsTreeInner.root.left.left = new BSTNode(16);
		bsTreeInner.root.left.right = new BSTNode(9);

		bsTreeInner.root.right.left = new BSTNode(4);
		bsTreeInner.root.right.right = new BSTNode(10);

		System.out.println("Expected:true Result:" + bsTreeMain.hasSubTree(bsTreeInner));

		bsTreeInner.root.right.right.right = new BSTNode(55);
		System.out.println("Expected:false Result:" + bsTreeMain.hasSubTree(bsTreeInner));
	}

	public static void main(String[] args) {
		new _7();
	}

	class BSTree {

		BSTNode root = null;

		public void inOrder() {
			inOrder(root);
		}

		public boolean hasSubTree(BSTree bsTreeInner) {
			BSTNode innerRoot = bsTreeInner.root;
			BSTNode innerRootInMainTree = root.searchNode(innerRoot.data);

			return hasSubTree(innerRootInMainTree, innerRoot);
		}

		private boolean hasSubTree(BSTNode main, BSTNode inner) {

			if (main == null && inner == null) {
				return true;
			}

			if (inner == null || main == null) {
				return false;
			}

			if (main != null && inner != null && main.data != inner.data) {
				return false;
			}

			return hasSubTree(main.left, inner.left) && hasSubTree(main.right, inner.right);

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

		private BSTNode searchNode(int data) {
			if (this.data == data) {
				return this;
			}

			BSTNode result = null;
			if (left == null) {
				return null;
			} else {
				result = left.searchNode(data);
			}

			if (result == null) {
				if (right == null) {
					return null;
				} else {
					return right.searchNode(data);
				}
			}
			return result;
		}
	}

}