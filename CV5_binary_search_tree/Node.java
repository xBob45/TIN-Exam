package binary_search_tree;

//https://www.guru99.com/binary-search-tree-data-structure.html
public class Node {
	
	

	//Atributy třídy
	public int number;
	
	//Každé vlákno "Node" ukazuje na dva "potomky"/podstromy na levo(prvky menší než výchozí vlákno), v pravo (prvky větší než výchozí vlákno)
	public Node right_branch;
	public Node left_branch;
	
	
	
	//Vlákna jsou reprezentovaná jako "parent-child" relationship
	//Každý "rodič" může mít 0 až dva potomky(subnodes)
		//Left-subnode = hodnoty nižší než než výchozí vlákno 
		//Right-subnode = hodnoty vyšší než výchozí vlákno
	public Node parent; //Ke každémy "potomkovi"/podstromu přidáváme informaci o "rodiči" tedy o jeho nadřazeném prvku.
	
	//Každé vlákno má z základu inicialozovanou hodnotu proměnné "number" na hodnotu zadanou při vytvoření a hodnota "potomků" je "null". Jelikož ještě žádní neexistují 
	public Node(int number) {
		super();
		this.number = number;
		right_branch = left_branch = null; // V první fázy neexistují žádné podstromy tj, vlánka na levo a na pravo.
	}

	@Override
	public String toString() {
		return String.format("%s",this.number);  
	}
	
	

}
