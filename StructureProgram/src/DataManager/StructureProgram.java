package DataManager;

import java.util.Scanner;

public class StructureProgram {
	// 사용자입력IO
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 점수배열
		ExamList list = new ExamList();

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			// 메뉴 출력
			printMenu();
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				// 점수 입력
				list.input(scan);
				break;
			case 2:
				// 점수 출력
				list.print();
				break;
			case 3:
				// 프로그램종료
				System.out.println("Bye~~");
				scan.close();
				keepLoop = false;
				break;
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           메인 메뉴                       │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
	}
}