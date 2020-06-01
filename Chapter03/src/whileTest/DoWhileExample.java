package whileTest;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {
		System.out.println("메세지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
		
		Scanner scan = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.print(">");
			inputString = scan.nextLine();
			System.out.println(inputString);
		} while( ! inputString.contentEquals("q") );
		
		System.out.println("프로그램종료");
	}
}