package whileTest;

import java.util.Scanner;

public class BankExample {
	static int balance = 0;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {		
		int input;
		
		do {
			System.out.println("-------------------------------");
			System.out.println("-  1.예금 | 2.출금 | 3.잔고 | 4.이체  -");
			System.out.println("-  5를 입력하면 종료됩니다                           -");
			System.out.println("-------------------------------");
			System.out.print("선택>");
			input = scan.nextInt();
			
			if(input == 1) {
				saving();
			}
			
			else if(input == 2) {
				withdraw();
			}
			
			else if(input == 3) {
				confirm();
			}
			
			else if(input == 4) {
				send();
			}
		} while( input != 5 );
			
	}

	private static void send() {
		// TODO Auto-generated method stub
		System.out.println("보낼 계좌 번호를 입력하세요");
		scan.nextLine();
		String account = scan.nextLine();
		
		System.out.println("보낼 금액을 입력하세요");
		int cost = scan.nextInt();
		
		System.out.println("해당 금액을 정말 출금하시겠습니까?? (y/n)");
		scan.nextLine();
		String check = scan.nextLine();
		
		if(check.equals("y")) {			
			balance -= cost;
			System.out.println(account + "계좌에 " + cost + "원을 송금했습니다");
		}
		else if(check.equals("n")) {
			return;
		}
	}

	public static void confirm() {
		// TODO Auto-generated method stub
		System.out.println("현재 잔고는: " + balance);
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("출금할 금액을 입력하세요");
		int cost = scan.nextInt();
		
		System.out.println("해당 금액을 정말 출금하시겠습니까?? (y/n)");
		scan.nextLine();
		String check = scan.nextLine();
		
		if(check.equals("y")) {
			System.out.println("출금 완료");
			balance -= cost;
		}
		else if(check.equals("n")) {
			return;
		}
		
	}

	private static void saving() {
		// TODO Auto-generated method stub
		System.out.println("예금할 금액을 입력하세요");
		int cost = scan.nextInt();
		
		System.out.println("해당 금액을 정말 예금하시겠습니까?? (y/n)");
		scan.nextLine();
		String check = scan.next();
		
		if(check.equals("y")) {	
			System.out.println("예금 완료");
			balance += cost;
		}
		else if(check.equals("n")) {
			return;
		}
	}
}
