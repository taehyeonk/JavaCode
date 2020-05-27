package ifTest;

import java.util.Scanner;

public class IFTest {
	public static void main(String[] args) {
		int count = 0;
		
		while(count < 5) {
			// 랜덤 넘버 생성
			int num = (int)(Math.random()*6) + 1;
			
			// Player가 예상 숫자 입력
			Scanner scan = new Scanner(System.in);
			System.out.print("예상 숫자는?");
			while (!scan.hasNextInt()) {
                scan.next();
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}
			int play_num = scan.nextInt();
			
			if(play_num < 1 || play_num > 6) {
				System.out.println("1에서 6 사이의 정수를 입력하세요!");
			}
			else {
				if(play_num == num) {
					System.out.println("맞췄습니다!" + num);
					count++;
					System.out.println("현재" + count + "개 맞췄습니다!");
				}
				else
					System.out.println("틀렸습니다! 정답: " + num);
			}

		}
	}
}
