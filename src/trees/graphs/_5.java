package trees.graphs;

public class _5 {
	public _5() {
		BSTree bsTree = new BSTree();

		BSTNode node3 = new BSTNode(3);
		BSTNode node11 = new BSTNode(11);
		BSTNode node20 = new BSTNode(20);
		BSTNode node40 = new BSTNode(40);
		BSTNode node19 = new BSTNode(19);

		bsTree.insert(bsTree.root, node20);
		bsTree.insert(bsTree.root, new BSTNode(10));
		bsTree.insert(bsTree.root, new BSTNode(30));
		bsTree.insert(bsTree.root, new BSTNode(5));
		bsTree.insert(bsTree.root, new BSTNode(15));
		bsTree.insert(bsTree.root, new BSTNode(25));
		bsTree.insert(bsTree.root, new BSTNode(35));
		bsTree.insert(bsTree.root, node3);
		bsTree.insert(bsTree.root, new BSTNode(7));
		bsTree.insert(bsTree.root, new BSTNode(12));
		bsTree.insert(bsTree.root, new BSTNode(18));
		bsTree.insert(bsTree.root, node19);
		bsTree.insert(bsTree.root, new BSTNode(23));
		bsTree.insert(bsTree.root, new BSTNode(28));
		bsTree.insert(bsTree.root, new BSTNode(33));
		bsTree.insert(bsTree.root, node40);
		bsTree.insert(bsTree.root, node11);

		System.out.println(node20.findNextSuccessor());
		System.out.println(node11.findNextSuccessor());
		System.out.println(node3.findNextSuccessor());
		System.out.println(node40.findNextSuccessor());
		System.out.println(node19.findNextSuccessor());
	}

	public static void main(String[] args) {
		new _5();
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
						newNode.parent = cursor;
						return;
					}
					cursor = cursor.right;
				} else if (data < cursor.data) {
					if (cursor.left == null) {
						cursor.left = newNode;
						newNode.parent = cursor;
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

		public void insert(BSTNode node, BSTNode newNode) {
			if (node == null) {
				root = newNode;
				return;
			}
			if (node.data == newNode.data) {
				return;
			}

			if (node.data > newNode.data) {
				if (node.left == null) {
					node.left = newNode;
					newNode.parent = node;
				} else {
					insert(node.left, newNode);
				}
			} else {
				if (node.right == null) {
					node.right = newNode;
					newNode.parent = node;
				} else {
					insert(node.right, newNode);
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
		BSTNode parent;

		public BSTNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public BSTNode findNextSuccessor() {

			if (isLeaf() && parent.left == this) {
				return parent;
			} else if (isLeaf() && parent.right == this) {
				BSTNode temp = this;
				while (temp != null && temp.parent != null && temp.parent.right == temp) {
					temp = temp.parent;
				}

				if (temp.parent != null && temp.parent.left != null) {
					return temp.parent.left.findNextSuccessor();
				}
				return null;
			} else if (left != null) {
				BSTNode temp = left;
				while (temp.left != null) {
					temp = temp.left;
				}
				return temp;
			} else if (right != null) {
				BSTNode temp = right;
				while (temp.left != null) {
					temp = temp.left;
				}
				return temp;
			}

			return null;
		}

		public boolean isRoot() {
			return parent == null;
		}

		public boolean isLeaf() {
			return right == null && left == null;
		}

		@Override
		public String toString() {
			return "" + data;
		}
	}

}