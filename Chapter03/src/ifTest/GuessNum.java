package ifTest;

import java.util.Scanner;

public class GuessNum {
	
	public static boolean checkString(String input_num) {
		char tmp;
		boolean output = true;
		
		for(int i=0; i<input_num.length(); i++) {
			tmp = input_num.charAt(i);
			
			if(!('0' <= tmp && tmp <= '9') ) {
				output = false;
			}
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		int random_num = (int)(Math.random()*100) +1; // 컴퓨터가 생성하는 랜덤값
		int score = 100; // 점수
		int count = 0; // 시도 횟수
		int n = 10; // 점수 감소 변수값
		
		// 게임 방법 소개 text
		System.out.println("------------------[게임방법]------------------");
		System.out.println("-----1. 점수는 100부터 시작됩니다------------------");
		System.out.println("-----2. 정답은 1부터 100 사이의 값입니다-------------");
		System.out.println("-----3. 정답과 오차가 클 수록 점수는 크게 감소합니다-------");
		System.out.println("-----4. 감소범위는 최대 4에서 최소 1입니다-------------");
		System.out.println("-----5. 시도 횟수는 점수가 0이 되기 전까지 가능합니다------");
		System.out.println("--------------------------------------------");
		
		
		System.out.println("예상하는 숫자를 입력해 주세요");
		
		while(score > 0) {
			int player_num = 0;
			Scanner scan = new Scanner(System.in);
			
			// 문자열 입력 예외처리
//			while (!scan.hasNextInt()) {
//                scan.next();
//                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
//			}
//			int player_num = scan.nextInt();
			
			String playerinput = scan.nextLine();
			
			if(checkString(playerinput) == false) {
				System.out.println("잘못된 입력입니다!");
			}
			else {
				player_num = Integer.parseInt(playerinput);
			}
			
			
			// 숫자 범위 예외처리
			if(player_num <= 0 || player_num >100) {
				System.out.println("0부터 100 사이의 숫자를 입력해 주세요");
			}
			
			else {
				count++;
				System.out.println(count + "번째 시도입니다");
				
				System.out.println("before: "+ score);
				int target = Math.abs(random_num-player_num);
				if (target == 0)
				{	System.out.println("정답입니다!!");
					break;
				}
				else if(target <=n)
				{
					score -= 1;
				}
				else if (target<=n*2)
				{
					score -= 2;
				}
				else if(target<=n*3)
				{
					score -= 3;
				}
				else
				{
					score -= 4;
				}
					
				
				System.out.println("after: "+ score);
				if(count>10)
					n/=2;
					
			}
			
		}
	}	
}
