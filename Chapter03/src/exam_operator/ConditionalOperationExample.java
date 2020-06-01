package exam_operator;

import java.util.Scanner;

public class ConditionalOperationExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("총점을 입력하세요");
		int sum = scan.nextInt();
		
		System.out.println((sum > 80) ? "합격" : "불합격");
	}
}
