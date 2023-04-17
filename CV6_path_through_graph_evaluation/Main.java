package path_through_graph_evaluation;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.add("1", "2", 4);
		g.add("1", "6", 6);
		g.add("1", "7", 16);
		g.add("2", "7", 8);
		
		Vertex v1 = g.getVertext("1");
		Vertex v2 = g.getVertext("2");
		Vertex v3 = g.getVertext("7");
		
		int cost = v2.getCost(v3);
		System.out.println(cost);

	}

}
