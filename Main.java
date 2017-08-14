import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datastructure.graph.Graph;
import datastructure.graph.edgelist.GraphEdge;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Graph<Integer, Integer> G = new GraphEdge<>();
		List<Integer> l = new ArrayList<>();
		LinkedList<Integer> linked = new LinkedList<>();
		Map<Integer, String> map = new HashMap<>();
		String[] s = {"Teste1", "Test2"};
		List<String> list = new ArrayList<>();
		list.add(s[0]); list.add(s[1]);
				
		map.put(null, s[0]);
		
		System.out.println(map.get(null));
				
		System.out.println(map.get(null));
				
	}
}
