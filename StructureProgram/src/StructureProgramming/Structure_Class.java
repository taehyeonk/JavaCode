package StructureProgramming;

import java.util.Scanner;

public class Structure_Class {
	// 사용자입력IO
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 점수배열
		Exam[] exams = new Exam[3];
		int current = 0;
		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			// 메뉴 출력
			printMenu();
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				// 점수 입력
				input(exams, current);
				break;
			case 2:
				// 점수 출력
				print(exams, current);
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
		System.out.println("│           메인 메뉴                   │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
	}

	private static void print(Exam[] exams, int current) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│          성적  출력                   │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for(int i=0;i<=current;i++) {
			int total = 0;
			float avg;
			total = exams[i].kor + exams[i].eng + exams[i].math;
			avg = total / 3.0f;
			System.out.printf("국어 : %3d\n", exams[i].kor);
			System.out.printf("영어 : %3d\n", exams[i].eng);
			System.out.printf("수학 : %3d\n", exams[i].math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}

	private static void input(Exam[] exams, int current) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  입력                   │");
		System.out.println("└───────────────────────────┘");
		System.out.println();
		exams[current] = new Exam();
		do {
			System.out.print("국어 : ");
			exams[current].kor = scan.nextInt();

			if (exams[current].kor < 0 || 100 < exams[current].kor)
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exams[current].kor < 0 || 100 < exams[current].kor);
		do {
			System.out.print("영어 : ");
			exams[current].eng = scan.nextInt();

			if (exams[current].eng < 0 || 100 < exams[current].eng)
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exams[current].eng < 0 || 100 < exams[current].eng);
		do {
			System.out.print("수학 : ");
			exams[current].math = scan.nextInt();

			if (exams[current].math < 0 || 100 < exams[current].math)
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exams[current].math < 0 || 100 < exams[current].math);
		System.out.println("─────────────────────────────");
	}
}