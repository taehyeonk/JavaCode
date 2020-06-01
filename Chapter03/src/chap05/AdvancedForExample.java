package chap05;

public class AdvancedForExample {
	public static void main(String[] args) {
		int[] scores = {93, 45, 69, 23, 77};
		int sum = 0;
		
		for(int score:scores) { // A : B -> A라는 변수명으로 B라는 집합체에서 하나씩 반복적으로 가져옴
			sum += score;
		}
		System.out.println(sum);
		
		sum = 0;
		
		int[][] sc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		for(int i=0; i<sc.length; i++) {
			for(int j=0; j<sc[i].length; j++) {
				sum += sc[i][j];
			}
		}
		
		System.out.println(sum);
		
		sum = 0;
		
		for(int[] score:sc) {
			for(int value:score) {
				sum += value;
			}
		}
		
		System.out.println(sum);
	}
}
