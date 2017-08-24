import datastructure.listanditerator.LinkedPositionList;
import datastructure.listanditerator.PositionList;

public class Main {
	public static void main(String[] args) {
		PositionList<Integer> list = new LinkedPositionList<>();
		for (int i = 0; i < 10; i++) list.addLast(i);
		list.forEach(System.out::print);
		
	}
}
