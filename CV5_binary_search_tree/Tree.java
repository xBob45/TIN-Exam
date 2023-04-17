package binary_search_tree;

public class Tree {
	
	//Vrchol stromu -> Top-level node, MAIN node, ROOT node
	private Node root_node;
	
	
	//Přidání prvku
	public void  add(int number) {
		
		//Kontrola jestli existuje vrchol stromu, tj. jestli strom není "prazdný"
		if (root_node == null) { 			//Jestli ANO, první prvek bude vrcholem stromu
			root_node = new Node(number); 	//Hodnota bude nastavena na základě hodnoty v "number"
			System.out.println("Root node " + root_node.number);
			root_node.parent = root_node;  //Rodičem vrcholu stromu bude vrchol sám, jelikož nad ním už nic není
		}
		
		else {
			add_recursive(root_node,number); //Jestli už nějaké prvky jsou tak se bude volat tato rekurze (POPSÁNA NÍŽE). "UZEL" je nastaven na "root_node" jelikož chceme strom procházet od shora
		}
		
	}
	
	private void add_recursive(Node node, int number) {
		if (number < node.number) { //Porovnání zadané hodnoty v proměnné "number" s hodnotou vrcholu STROMU/POD-STROMU	
			if (node.left_branch == null) { //Pokud na levo od uzlu z kterého jsme vyšli něco je -> je nutné se posunout "hlouběji" -> rekurzivní volání.
				System.out.println("Number has been inserted " + number + " to left of " + node.number); //Pokud na levo od výchozího uzlu je místo, tak se tam vloží nový objekt "pod-uzel"
				node.left_branch = new Node(number);
				node.left_branch.parent = node; //Rodičem névě vytvořeného uzlu bude, uzel ze kterého se vyšlo
				
			}
			else {
				add_recursive(node.left_branch,number);
			}
		}
		
		else if (number > node.number) {
			if (node.right_branch == null) {
				System.out.println("Number has been inserted " + number + " to right of " + node.number);
				node.right_branch = new Node(number);
				node.right_branch.parent = node;
			}
			else {
				add_recursive(node.right_branch, number);	
			}
		}
		
	}
	
	public void search(int number) {
		if (root_node == null) { //Kontrola jsou-li ve stromu nějaké prvky 
			System.out.println("Tree is empty");
		}
		else {
			search_recursive(root_node, number); // Jestli STROM není prázdný tak budeme strom rekurzibně procházet pomocí této funkce. Začínáme od vrchlu stromu proto volíme jako první "Node" jako "root_node"
		}
		
	}
	
	private void search_recursive(Node node, int number) {
		if (node.number == number) { //Pokud najdeme uzel jehož hodnota je rovna hledané tak skončíme
			System.out.println("True");
			System.out.println("Number " + number + " has been found in node "+ node.parent);
		}
		else if (number < node.number) { // Porovnáme jestli hodnota na základě, které hledáme je >, < a na základě toho půjedem po kokrétní větvy stromu/podstromu
			if (node.left_branch != null) { // Poku je splněna podmínka výše musí se ještě skonstrolovat jestli nalevo od vrcholu STROMU/POD-STROMU je nějaký prvek nebo ne. Pokud ano tak rekurzivně zavoláme stejnou funkci a vyjdeme z tohoto vlákna a takto postupujeme stromeme
				search_recursive(node.left_branch, number);
			}
			else {
				System.out.println("False"); //Jestliže na levo od vrcholu STROMU/POD-STROMU už nic není -> došli jsem na konec větve a hledaný prvek jsem nenašli
				System.out.println("Number isn't presented in the tree");
			}
		}	
		else if (number > node.number) {
			if (node.right_branch != null) {
					search_recursive(node.right_branch, number);
			}
			else {
				System.out.println("False");
				System.out.println("Number isn't presented in the tree");
			}
			
		}	
	}
	
	public void delete(int number) {
		if (root_node == null) {
			System.out.println("Tree is empty");
		}
		else {
			delete_recursive(root_node, number);
		}	
	}
	
	private void delete_recursive(Node node, int number) {
		if (node.number == number) {
			System.out.println("Number has been deleted from node "+ node);
			node = null;
		}
		else if (number < node.number) {
			if (node.left_branch == null) {
				System.out.println("Number isn't presented in the tree");
			}
			else {
				search_recursive(node.left_branch, number);	
			}
		}	
		else if (number > node.number) {
			if (node.right_branch == null) {
				System.out.println("Number isn't presented in the tree");
					
			}
			else {
				search_recursive(node.right_branch, number);	
			}
			
		}	
	}
	
	/*Skládá prvky stromu od nejmešího po největší*/
	public void inOrder() {
		System.out.println("Elements of tree in order: ");
		inOrder_recursive(root_node);
	}
	
	public void inOrder_recursive(Node node) {
		if (node != null) {
			inOrder_recursive(node.left_branch);
			System.out.print(" " + node.number);
			inOrder_recursive(node.right_branch);
		}
		
	}
	
	/*KOŘEN, Levá strana (od shora dolů), Pravá strana (od shora dolů)*/
	public void preOrder() {
		System.out.println("Elements of tree pre-order: ");
		preOrder_recursive(root_node);	
	}
	
	public void preOrder_recursive(Node node) {
		if (node != null) {
			System.out.print(node.number + " "); 
	        preOrder_recursive(node.left_branch); 
	        preOrder_recursive(node.right_branch); 
		}
	}
	
	//Levá strana (od zdola nahoru), Pravá strana (od zdola nahoru), KOŘEN	
	public void postOrder() {
		System.out.println("Elements of tree post-order: ");
		postOrder_recursive(root_node);	
	}
	
	public void postOrder_recursive(Node node) {
		if (node != null) {
	        postOrder_recursive(node.left_branch); 
	        postOrder_recursive(node.right_branch); 
	        System.out.print(node.number + " "); 
		}
	}



}
	
	
	

