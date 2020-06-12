package DataManager;

import java.util.Scanner;

public class ExamList {
	private Exam[] exams;
	private int current;
	
	public ExamList() {
		this(new Exam[3], 0); // 생성자에서 생성자 호출은 this();로 가능
	}

	public ExamList(Exam[] exams, int current) {
		this.exams = exams;
		this.current = current;
	}

	public void print() {
		print(this.current);
	}
	
	public void print(int size) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  출력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for(int i=0;i<size;i++) {
			Exam exam = exams[i]; // 임시변수를 사용 (배열 연산도 줄일 수 있음)
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
		Exam exam = exams[current];
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
		current++;
		if(exams.length >= current) {
			Exam[] temp = new Exam[current + 3];
			for(int i=0; i<current; i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
		System.out.println("─────────────────────────────");
	}
}