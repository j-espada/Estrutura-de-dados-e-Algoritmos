
public class Main {
	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");

		System.out.println();
		// Different ways to traverse binary trees

		theTree.inOrderTraverseTree(theTree.root);
		System.out.println();
		// theTree.preorderTraverseTree(theTree.root);
		// System.out.println();
		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		// System.out.println("\nNode with the key 75");

		// System.out.println(theTree.findNode(75));
		// System.out.println(theTree.treeMaximum(theTree.root));
		// System.out.println(theTree.treeMinimum(theTree.root));

		System.out.println("Node a analisar : " + theTree.nodesWithParents.get(0) + " Sucessor :");
		theTree.treeSucessor(theTree.nodesWithParents.get(0));
		System.out.println();
		System.out.println("Node a analisar : " + theTree.nodesWithParents.get(2) + " Predecessor :");
		theTree.treePredecessor(theTree.nodesWithParents.get(2));

		// theTree.inOrderTraverseTree(theTree.root);
		System.out.println();
		System.out.println("Node a Remover : " + theTree.nodesWithParents.get(0));
		theTree.delete(theTree.nodesWithParents.get(0));
		theTree.inOrderTraverseTree(theTree.root);

	}
}
