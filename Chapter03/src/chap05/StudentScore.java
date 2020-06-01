package chap05;

import java.util.Scanner;

public class StudentScore {
	public static void main(String[] args) {
		int[][] score;
		String[] subject = {"국어", "영어", "수학"};
		double[] avg = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		double[] subject_avg = {0, 0, 0};
		score = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 	// 국어
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 	// 영어
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};	// 수학
		
		
		Scanner scan = new Scanner(System.in);
		
		// 성적 입력
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[0].length; j++) {
				System.out.println(j+1 + "번째 학생의 " + subject[i] + "성적을 입력하세요");
				
				// 문자열 입력 예외처리
				while (!scan.hasNextInt()) {
	                scan.next();
	                System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
				}
				
				// 숫자 범위 예외처리
				while (true) {
					score[i][j] = scan.nextInt();
					
					if(score[i][j] < 0 || score[i][j] > 100) {
						System.out.println("0에서 100사이의 값을 입력해 주세요");
					}
					
					else {
						break;
					}
				}
				
			}
		}
		
		// 입력값 확인용 코드
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[0].length; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println("");
		}
		
		// 성적 처리 - 학생별 총점 평균
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[0].length; j++) {
				avg[j] += score[i][j];
				subject_avg[i] += score[i][j];
			}
		}
		
		for(int i=0; i<score[0].length; i++) {
			avg[i] = avg[i] / score.length;
		}
		
		for(int i=0; i<score.length; i++) {
			subject_avg[i] = subject_avg[i] / score[0].length;
		}
		
		// 출력
		System.out.println("[과목 평균]");
		for(int i=0; i<score.length; i++) {
			System.out.println(subject[i] + "의 평균" + subject_avg[i]);
		}
		
		System.out.println("[학생 별 총점 평균]");
		for(int i=0; i<score[0].length; i++) {
			System.out.println(i+1 + "번째 학생의 성적:" + avg[i]);
		}
	}
}
