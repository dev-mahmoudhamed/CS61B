
public class BST {

	private class Node {
		Integer key;
		Node left, right;

		Node(Integer key) {
			this.key = key;
			left = right = null;
		}
	}

	Node root;

	public BST() {
		root = null;
	}

	public BST(Integer key) {
		root = new Node(key);
	}

	public Integer find(Integer key) {
		return search_internally(root, key).key;
	}

	// Private method hide insert implementation of searching.
	private Node search_internally(Node root, Integer key) {
		if (key == root.key) {
			return root;
		} else if (key > root.key) {
			return search_internally(root.right, key);
		} else {
			return search_internally(root.left, key);
		}
	}

	public void insert(Integer key) {
		root = insert_internally(root, key);
	}

	// Private method hide insert implementation of insertion.
	private Node insert_internally(Node root, Integer item) {
		if (root == null) {
			return new Node(item);
		}
		if (item > root.key) {
			root.right = insert_internally(root.right, item);
		} else if (item < root.key) {
			root.left = insert_internally(root.left, item);
		}
		return root;
	}

	public void delete(Integer key) {
		root = search_internally(root, key);
		if (root.left == null && root.right == null) {
			root = null;
		}

		if (root.right == null) {
			root.key = root.left.key;
		} else if (root.left == null) {
			root.key = root.right.key;
		}

		else {
			Hibbard_Deletion(root);
		}
	}

	private void Hibbard_Deletion(Node root) {
		Node successor = root.right;
		while (successor.left != null) {
			successor = successor.left;
		}
		root = successor;
		if (successor.right != null) {
			successor.key = successor.right.key;
		}
	}
}
