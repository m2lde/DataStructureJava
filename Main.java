import datastructure.graph.AdjacencyListGraph;
import datastructure.graph.AdjacencyMapGraph;
import datastructure.graph.Edge;
import datastructure.graph.Graph;
import datastructure.graph.Vertex;

@SuppressWarnings("unused")
public class Main {
	@SuppressWarnings("unchecked")
	public static void testGraph(Graph<Integer, String> G) {
		AdjacencyListGraph<Integer, String> T = (AdjacencyListGraph<Integer, String>) G;
		Vertex<Integer> v[] = new Vertex[6];
		Edge<String> e[] = new Edge[10];
		
		for (int i = 0; i < v.length; i++) v[i] = T.insertVertex(i);
		
		e[0] = T.insertEdge(v[0], v[2], "a");
		e[1] = T.insertEdge(v[0], v[4], "b");
		e[2] = T.insertEdge(v[0], v[3], "c");
		e[3] = T.insertEdge(v[2], v[4], "e");
		e[4] = T.insertEdge(v[2], v[1], "f");
		e[5] = T.insertEdge(v[3], v[4], "d");
		e[6] = T.insertEdge(v[3], v[5], "h");
		e[7] = T.insertEdge(v[4], v[1], "g");
		e[8] = T.insertEdge(v[4], v[5], "i");
		e[9] = T.insertEdge(v[5], v[1], "j");
		
		/**
		System.out.println(T.opposite(v[0], e[0]).getElement());
		System.out.println(T.opposite(v[0], e[1]).getElement());
		System.out.println(T.opposite(v[0], e[2]).getElement());
		
		System.out.println(e[0].getElement());
		System.out.println(e[1].getElement());
		System.out.println(e[2].getElement());
		
		for (Vertex<Integer> verts : v) {
			T.FuncTmp(verts);
		}
		*/
		
		System.out.print("Edges: \t\t");
		G.edges().forEach(ed->System.out.print(" " + ed.getElement()));
		System.out.println();
		System.out.print("Vertices: \t");
		G.vertices().forEach(ed->System.out.print(" " + ed.getElement()));
		System.out.println();
		System.out.println("GRAPH::");
		System.out.println(G.toString());
		G.removeVertex(v[4]);
		
		System.out.println();
		System.out.println("GRAPH::");
		System.out.println(G.toString());
		/**
		System.out.print("Edges:");
		G.edges().forEach(ed -> System.out.print(" " + ed.getElement()));
		System.out.println();
		System.out.println(":::::::::::::::::::::Vertices:::::::::::::::::::::");
		G.vertices().forEach(ed -> System.out.print(" " + ed.getElement()));
		System.out.println();
		System.out.println(":::::::::::::::::::::GRAPH:::::::::::::::::::::");
		System.out.println(G.toString());
		*/
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Graph<Integer, String> G1 = new AdjacencyListGraph<>(false);
		Graph<Integer, String> G2 = new AdjacencyListGraph<>(true);
		
		testGraph(G2);
						
		
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
