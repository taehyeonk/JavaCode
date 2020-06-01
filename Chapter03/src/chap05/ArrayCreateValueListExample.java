package chap05;

public class ArrayCreateValueListExample {
	public static void main(String[] args) {
		int[] scores = {34, 65, 89};
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores.length);
		
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
	}
}
