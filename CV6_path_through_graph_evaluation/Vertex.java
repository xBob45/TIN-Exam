package path_through_graph_evaluation;

import java.util.HashMap;
import java.util.HashSet;

public class Vertex {
	
	private String name; 										//Hodnota v kolečku každého vrcholu grafu
	private HashSet<Vertex> vertexSet = new HashSet<Vertex>(); //Sousední vrcholy daného vrcholu
	private HashMap<Vertex, Integer> costs = new HashMap<Vertex, Integer>(); //Sousední vrcholy a "cena" cesty k nim
	
	
	//Parametrický konstruktor,skrze který dojde k inicializování "name" proměnné 
	public Vertex(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getCost(Vertex v) {
		return costs.get(v);
	}
	
	public void addConnection(Vertex v2, int cost) { //"v2" protože v1 bude vrchol na, který se tato metoda bude aplikovat
		vertexSet.add(v2); 	     //Vložení vrcholu (objekt) do množiny sousedních vrcholů.
		costs.put(v2, cost);	// Vložení asociace 'vrchol : hodnota cesty mezi v1 (vrchol na, který se metoda 'volá' a druhým vrcholem 'v2')'
	}
}

