package binary_search_tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Tree BST = new Tree();
		
		BST.add(7);
		BST.add(5);
		BST.add(14);
		BST.add(1);
		BST.add(6);
		BST.add(10);
		BST.add(16);
		
		System.out.println("\n");
		BST.search(3);
		System.out.println("\n");
		
		System.out.print("InOrder: ");
		BST.preOrder();
		System.out.println("\n");
		
		
		System.out.print("PreOrder: ");
		BST.inOrder();
		System.out.println("\n");
		
		System.out.print("PostOrder: ");
		BST.postOrder();
		System.out.println("\n");
		
	
	}

}
