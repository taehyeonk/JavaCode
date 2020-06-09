package exam01;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		List<String> list = new Vector<String>();
		list.add("java");
		list.add("JDBC");
		list.add("Database");
		
		System.out.println(list.size());
		System.out.println();
		
		list.add(1, "study");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
