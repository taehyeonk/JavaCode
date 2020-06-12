package UIExam;

import java.util.Scanner;

public class ExamConsole {
	ExamList list = new ExamList();
	
	public static void printMenu() {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           메인 메뉴                       │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
	}
	
	public void print() {
		print(list.getCurrent());
	}
	
	public void print(int size) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  출력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for(int i=0;i<size;i++) {
			Exam exam = list.get(i); // 임시변수를 사용 (배열 연산도 줄일 수 있음)
			int total = 0;
			float avg;
			total = exam.getTotal();
			avg = exam.getEvg();
			System.out.printf("국어 : %3d\n", exam.getKor());
			System.out.printf("영어 : %3d\n", exam.getEng());
			System.out.printf("수학 : %3d\n", exam.getMath());
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}
	
	public void input(Scanner scan) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  입력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();
//		exams[current] = new Exam();
		Exam exam = list.get(list.getCurrent());
		exam = new Exam();
		
		do {
			System.out.print("국어 : ");
			exam.setKor(scan.nextInt());

			if (exam.getKor() < 0 || 100 < exam.getKor())
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getKor() < 0 || 100 < exam.getKor());
		do {
			System.out.print("영어 : ");
			exam.setEng(scan.nextInt());

			if (exam.getEng() < 0 || 100 < exam.getEng())
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getEng() < 0 || 100 < exam.getEng());
		do {
			System.out.print("수학 : ");
			exam.setMath(scan.nextInt());

			if (exam.getMath() < 0 || 100 < exam.getMath())
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getMath() < 0 || 100 < exam.getMath());
		
		list.add(exam);
		System.out.println("─────────────────────────────");
	}
}
