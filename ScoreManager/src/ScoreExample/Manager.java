package ScoreExample;

import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		Student stu[] = new Student[100];
		int menu_num = 0;
		int index = 0;	
		
		Scanner scan = new Scanner(System.in);
		
		while(menu_num != 5) {
			System.out.println("----------------------");
			System.out.println("-1. 학생등록--");
			System.out.println("-2. 성적 조회--");
			System.out.println("-3. 학생 총점 / 평균--");
			System.out.println("-4. 과목 총점 / 평균--");
			System.out.println("-5. 종료--");
			System.out.println("----------------------");
			System.out.println("선택>");
			
			menu_num = scan.nextInt();
			
			switch (menu_num) {
			case 1:
				System.out.println("이름을 입력하세요");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.println("휴대폰 번호를 입력하세요");
				String phone_num = scan.nextLine();
				
				System.out.println("국어성적을 입력하세요");
				int kor = scan.nextInt();
				System.out.println("영어성적을 입력하세요");
				int eng = scan.nextInt();
				System.out.println("수학성적을 입력하세요");
				int math = scan.nextInt();
				
				stu[index] = new Student(name, phone_num, kor, eng, math);
				index++;
				
				break;
			case 2:
				double score[] = {0, 0, 0};
				System.out.println("조회할 학생의 이름을 입력해주세요");
				scan.nextLine();
				String stu_name = scan.nextLine();
				
				for(int i=0; i<index; i++) {
					if(stu_name.equals(stu[i].get_name())) {
						score[0] = stu[i].get_score("국어");
						score[1] = stu[i].get_score("영어");
						score[2] = stu[i].get_score("수학");
					}
				}
				
				System.out.println("국어성적 :" + score[0]);
				System.out.println("영어성적 :" + score[1]);
				System.out.println("수학성적 :" + score[2]);
				
				break;
			case 3:
				System.out.println("총점을 알고싶은 학생의 이름을 입력하세요");
				scan.nextLine();
				stu_name = scan.nextLine();
				
				double total_score = 0;
				
				for(int i=0; i<index; i++) {
					if(stu_name.equals(stu[i].get_name())) {
						total_score = stu[i].get_student_total();
					}
				}
				
				System.out.println(stu_name + "의 총점 : " + total_score);
				System.out.println(stu_name + "의 평균 : " + total_score / 3.0);
				
				break;
			case 4:
				double subject_total[] = {0, 0, 0};
				
				for(int i=0; i<index; i++) {
					subject_total[0] += stu[i].get_score("국어");
					subject_total[1] += stu[i].get_score("영어");
					subject_total[2] += stu[i].get_score("수학");					
				}
				
				System.out.println("국어 성적의 총점 : " + subject_total[0] + " 평균 : " + subject_total[0] / index);
				System.out.println("영어 성적의 총점 : " + subject_total[1] + " 평균 : " + subject_total[1] / index);
				System.out.println("수학 성적의 총점 : " + subject_total[2] + " 평균 : " + subject_total[2] / index);
				break;			
			}
		}
		
	}
}
