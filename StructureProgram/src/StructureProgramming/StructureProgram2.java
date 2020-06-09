package StructureProgramming;

import java.util.Scanner;

public class StructureProgram2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] korList = new int[3];
		int[] engList = new int[3];
		int[] mathList = new int[3];
		
		int menu;
		boolean keepLoop = true;		

		while (keepLoop) {
			printmenu();
			menu = scan.nextInt();

			switch (menu) {
				case 1:
					inputScore(korList, engList, mathList, scan);
					break;
				case 2:
					printScore(korList, engList, mathList);
					break;
				case 3:
					System.out.println("Bye~~");
					scan.close(); // scan을 밖을 뺐기 때문에 시스템이 종료되는 타이미엥 close 해준다.
					keepLoop = false;
					break;
				default:
					System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}		
	}
    
    public static void printmenu() {
    	System.out.println("┌───────────────────────────┐");
		System.out.println("│           메인 메뉴                       │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
    }
    
    public static void inputScore(int[] kors, int[] engs, int[] maths, Scanner scan) {
    	System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  입력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for (int i = 0; i < 3; i++) {
			boolean state = true;
			
			while(state) {
				System.out.printf("국어%d : ", i + 1);
				kors[i] = scan.nextInt();
				
				System.out.printf("영어%d : ", i + 1);
				engs[i] = scan.nextInt();
				
				System.out.printf("수학%d : ", i + 1);
				maths[i] = scan.nextInt();

				if ((kors[i] < 0 || 100 < kors[i]) || (engs[i] < 0 || 100 < engs[i]) || (maths[i] < 0 || 100 < maths[i]))
					System.out.println("성적은 0~100까지의 범위만 입력이 가능합니다.");
				else
					state = false;
			}
		}
		System.out.println("─────────────────────────────");
    }
    
    public static void printScore(int[] kors, int[] engs, int[] maths) {
    	int[] total = new int[3];
		float[] avg = new float[3];
    	String[] name= {"국어","영어","수학"};
    	for (int i = 0; i < 3; i++) {
			total[0] += kors[i]; // total[0] = 국어
			total[1] += engs[i]; // total[1] = 영어
			total[2] += maths[i]; // total[2] = 수학			
    	}

    	for(int i=0; i < 3; i++) {
    		avg[i] = total[i]/3.0f;
    	}

		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  출력                      │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for (int i = 0; i < 3; i++)
			System.out.printf("%s %d : %3d\t %s %d : %3d\t %s %d : %3d\n",name[0],i+1, kors[i],
					name[1],i+1, engs[i],name[2],i+1, maths[i]);
		for (int i = 0; i < 3; i++)
			System.out.printf("%s 총점 : %3d\t", name[i], total[i]);
		System.out.println();
		for (int i = 0; i < 3; i++)
			System.out.printf("%s 평균 : %3.1f\t", name[i], avg[i]);
		System.out.println();

		
		System.out.println("─────────────────────────────");
    }
}
