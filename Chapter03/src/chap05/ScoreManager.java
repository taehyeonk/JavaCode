package chap05;

import java.util.Scanner;

public class ScoreManager {
	public static void main(String[] args) {
		
		int[] score;
		int sum = 0;
		double avg = 0;
		Scanner scan = new Scanner(System.in);
		
		score = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for(int i=0; i<score.length; i++) {
			score[i] = scan.nextInt();
		}
		
		for(int i=0; i<10; i++) {
			sum += score[i];
		}
		
		avg = (double)sum / score.length;
		System.out.println(sum + " " + avg);
	}
}
