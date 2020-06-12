package StructureProgramming;

import java.util.Scanner;

public class StructureProgram5 {
	// 사용자입력IO
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 점수배열
		ExamList list = new ExamList();
		list.init(new Exam[3], 0);

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			// 메뉴 출력
			printMenu();
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				// 점수 입력
				input(list);
				break;
			case 2:
				// 점수 출력
				print(list);
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

	private static void print(ExamList list) {
		print(list, list.current);
	}
	
	private static void print(ExamList list, int size) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  출력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for(int i=0;i<size;i++) {
			int total = 0;
			float avg;
			total = list.exams[i].kor + list.exams[i].eng + list.exams[i].math;
			avg = total / 3.0f;
			System.out.printf("국어 : %3d\n", list.exams[i].kor);
			System.out.printf("영어 : %3d\n", list.exams[i].eng);
			System.out.printf("수학 : %3d\n", list.exams[i].math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}

	private static void input(ExamList list) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  입력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();
		list.exams[list.current] = new Exam();
		do {
			System.out.print("국어 : ");
			list.exams[list.current].kor = scan.nextInt();

			if (list.exams[list.current].kor < 0 || 100 < list.exams[list.current].kor)
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (list.exams[list.current].kor < 0 || 100 < list.exams[list.current].kor);
		do {
			System.out.print("영어 : ");
			list.exams[list.current].eng = scan.nextInt();

			if (list.exams[list.current].eng < 0 || 100 < list.exams[list.current].eng)
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (list.exams[list.current].eng < 0 || 100 < list.exams[list.current].eng);
		do {
			System.out.print("수학 : ");
			list.exams[list.current].math = scan.nextInt();

			if (list.exams[list.current].math < 0 || 100 < list.exams[list.current].math)
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (list.exams[list.current].math < 0 || 100 < list.exams[list.current].math);
		list.current++;
		if(list.exams.length >= list.current) {
			Exam[] temp = new Exam[list.current + 3];
			for(int i=0; i<list.current; i++) {
				temp[i] = list.exams[i];
			}
			list.exams = temp;
		}
		System.out.println("─────────────────────────────");
	}
}