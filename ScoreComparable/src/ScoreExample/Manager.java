package ScoreExample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		
		List<Student> list = new LinkedList<>();
		int menu_num = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(menu_num != 4) {
			System.out.println("----------------------");
			System.out.println("-1. 성적 입력--");
			System.out.println("-2. 성적 삭제--");
			System.out.println("-3. 성적리스트 출력--");
			System.out.println("-4. 종료--");
			System.out.println("----------------------");
			System.out.print("선택>");
			
			menu_num = scan.nextInt();
			
			switch (menu_num) {
			case 1:
				System.out.println("이름을 입력하세요");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.println("ID를 입력하세요");
				int id = scan.nextInt();
				
				System.out.println("국어성적을 입력하세요");
				int kor = scan.nextInt();
				System.out.println("영어성적을 입력하세요");
				int eng = scan.nextInt();
				System.out.println("수학성적을 입력하세요");
				int math = scan.nextInt();
				
				list.add(0, new Student(id, name, kor, eng, math));
				
				break;
			case 2:
				System.out.println("삭제할 학생의 ID를 입력해주세요");
				int delete_id = scan.nextInt();
				for(int i=0; i<list.size(); i++) {
					Student s = list.get(i);
					if(delete_id == s.getId()) {
						list.remove(i);
					}
				}				
				break;
			case 3:
				Collections.sort(list, Collections.reverseOrder());
				for(Student s : list) {
					System.out.println(s.toString());
				}
				
				break;		
			}
		}
	}
}
