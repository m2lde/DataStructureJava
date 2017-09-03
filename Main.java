import datastructure.graph.AdjacencyListGraph;
import datastructure.graph.AdjacencyMapGraph;
import datastructure.graph.Graph;
import datastructure.graph.Vertex;

@SuppressWarnings("unused")
public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Graph<Integer, String> G1 = new AdjacencyListGraph<>(false);
		Graph<Integer, String> G2 = new AdjacencyListGraph<>(true);
		Vertex<Integer> v[] = new Vertex[6];
		Vertex<Integer> v2[] = new Vertex[6];
		
		for (int i = 0; i < v.length; i++) {
			v[i] = G1.insertVertex(i + 1);
			v2[i] = G2.insertVertex(i);
		}
		
		
		G2.insertEdge(v2[0], v2[2], "a");
		G2.insertEdge(v2[0], v2[4], "b");
		G2.insertEdge(v2[0], v2[3], "c");
		G2.insertEdge(v2[2], v2[4], "e");
		G2.insertEdge(v2[2], v2[1], "f");
		G2.insertEdge(v2[3], v2[4], "d");
		G2.insertEdge(v2[3], v2[5], "h");
		G2.insertEdge(v2[4], v2[1], "g");
		G2.insertEdge(v2[4], v2[5], "i");
		G2.insertEdge(v2[5], v2[1], "j");
		
		
		//System.out.println(G2.toString());
		//G2.removeVertex(v2[4]);
		//System.out.println(G2.toString());
		//G2.edges().forEach(e->System.out.println(e.getElement()));
		/**
		System.out.println("Vertices values.");
		G1.vertices().forEach(action -> System.out.print(" " + action.getElement()));
		System.out.println("\n");
		
		G1.insertEdge(v[0], v[0], "a");
		G1.insertEdge(v[0], v[4], "b");
		G1.insertEdge(v[0], v[1], "c");
		G1.insertEdge(v[1], v[4], "d");
		G1.insertEdge(v[4], v[3], "f");
		G1.insertEdge(v[1], v[2], "e");
		G1.insertEdge(v[2], v[3], "g");
		G1.insertEdge(v[3], v[5], "h");
		
		System.out.println(G1.toString());
		G1.removeVertex(v[0]);
		G1.removeVertex(v[2]);
		G1.removeEdge(G1.getEdge(v[2], v[3]));
		//System.out.println("Edge:::::::::" + G1.getEdge(v[4], v[5]));
		System.out.println(G1.toString());
		
		System.out.println("Vertices values.");
		G1.vertices().forEach(action -> System.out.print(" " + action.getElement()));
		System.out.println("\n");
		
		System.out.println("Edges values.");
		G1.edges().forEach(action -> System.out.print(" " + action.getElement()));
		System.out.println("\n");
		*/
	}
}
