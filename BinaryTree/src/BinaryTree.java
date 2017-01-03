import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	Node root;
	List<Node> nodesWithParents = new ArrayList<Node>();

	// http://www.newthinktank.com/2013/03/binary-tree-in-java/
	public void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;
			root.parent = null;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						newNode.parent = parent;
						nodesWithParents.add(newNode);
						return; // All Done

					}

				}

				else

				{ // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						newNode.parent = parent;
						nodesWithParents.add(newNode);
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println("Parent ->" + focusNode.parent + " Node -> " + focusNode + " LeftChild -> "
					+ focusNode.leftChild + " RightChild -> " + focusNode.rightChild);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

	public Node treeMinimum(Node x) {

		while (x.leftChild != null) {

			x = x.leftChild;

		}
		return x;
	}

	public Node treeMaximum(Node x) {

		while (x.rightChild != null) {

			x = x.rightChild;

		}
		return x;
	}

	public Node treeSucessor(Node x) {

		if (x == null)
			return null;

		if (x.rightChild != null) {
			System.out.println(treeMinimum(x.rightChild));
			return treeMinimum(x.rightChild);
		}

		Node y = x.parent;
		System.out.println(y);
		while (y != null && x == y.rightChild) {

			x = y;
			y = y.parent;
		}
		System.out.println(y);
		return y;

	}

	public Node treePredecessor(Node node) {
		if (node == null)
			return null;

		if (node.leftChild != null)
			return treeMaximum(node.leftChild);

		Node parent = node.parent;

		Node y = parent;
		Node x = node;
		while (y != null && x == y.leftChild) {
			x = y;
			y = y.parent;
		}
		System.out.println(y);
		return y;
	}

	private void transplant(Node u, Node v) {

		if (u.parent == null) {
			this.root = v;
		}

		else if (u == u.parent.leftChild) {
			u.parent.leftChild = v;

		} else {
			u.parent.rightChild = v;
		}
	}

	public void delete(Node z) {
		Node y;

		if (z.leftChild == null)
			transplant(z, z.rightChild);

		else if (z.rightChild == null)
			transplant(z, z.leftChild);
		else {
			y = treeMinimum(z.rightChild);

			if (!y.parent.equals(z)){
				transplant(y, y.rightChild);
				y.rightChild = z.rightChild;
				y.rightChild.parent = y;
			}

			transplant(z, y);
			y.leftChild = z.leftChild;
			y.leftChild.parent = y;
		}

	}
}