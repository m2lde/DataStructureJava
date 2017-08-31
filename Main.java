import datastructure.graph.AdjacencyListGraph;
import datastructure.graph.AdjacencyMapGraph;
import datastructure.graph.Edge;
import datastructure.graph.Graph;
import datastructure.graph.Vertex;

@SuppressWarnings("unused")
public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Graph<Integer, String> G = new AdjacencyListGraph<>(false);
		Vertex<Integer> v[] = new Vertex[6];
		
		for (int i = 0; i < v.length; i++) v[i] = G.insertVertex(i + 1);
		
		System.out.println("Vertices values.");
		G.vertices().forEach(action -> System.out.print(" " + action.getElement()));
		System.out.println("\n");
		
		G.insertEdge(v[0], v[0], "a");
		G.insertEdge(v[0], v[4], "b");
		G.insertEdge(v[0], v[1], "c");
		G.insertEdge(v[1], v[4], "d");
		G.insertEdge(v[4], v[3], "f");
		G.insertEdge(v[1], v[2], "e");
		G.insertEdge(v[2], v[3], "g");
		G.insertEdge(v[3], v[5], "h");
		
		System.out.println(G.toString());
		G.removeVertex(v[5]);
		System.out.println(G.toString());
	}
}
