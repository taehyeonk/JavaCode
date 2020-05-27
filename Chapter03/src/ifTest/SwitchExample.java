package ifTest;

import java.util.Scanner;

public class SwitchExample {
	public static void main(String[] args) {
		while(true) {
			System.out.println("점수를 입력하세요");
			Scanner scan = new Scanner(System.in);
			
			// 입력값 숫자가 아닐경우 예외처리
			while (!scan.hasNextInt()) {
                scan.next();
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}
			
			int score = scan.nextInt();
			
			switch(score / 10) {
				case 10:
					System.out.println("A+");
					break;
				
				case 9:
					System.out.println("A");
					break;
					
				case 8:
					System.out.println("B");
					break;
					
				case 7:
					System.out.println("C");
					break;
					
				case 6:
					System.out.println("D");
					break;
					
				default :
					System.out.println("F");
			}
		}
	}
}
