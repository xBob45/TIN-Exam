package path_through_graph_evaluation;

import java.util.HashMap;

public class Graph {
	
	private HashMap<String, Vertex> vertexSet = new HashMap<String, Vertex>(); 
	
	
	public void add(String v1Name, String v2Name, int cost) { //Metoda, pro přidání nového vrcholu do grafu
		Vertex vertex1 = vertexSet.get(v1Name); 			 //Tento řádek slouží ke kontrole, jestli tam je objekt typu "Vertex" názvu "v1Name"
		Vertex vertex2 = vertexSet.get(v2Name);
		
		if (vertex1 == null) {		//Jestli s názvem "v1Name" není asociován v mapě žádný objekt "Vertex",
			vertex1 = new Vertex(v1Name); //tak se vytvoří nový objekt s tímto názvem
			vertexSet.put(v1Name, vertex1); // a do mapy se vloží.
		}
		if (vertex2 == null) {
			vertex2 = new Vertex(v2Name);
			vertexSet.put(v2Name, vertex2);
		}
		
		
		//Poté co proběhne co je zajištěna existence obou vrcholů, může dojít k vytvoření cesty a jejímu ohodnocení 
		vertex1.addConnection(vertex2, cost);
		
	}
		
	public Vertex getVertext(String name) {
		return vertexSet.get(name);
	}
		
		
		
	

}
