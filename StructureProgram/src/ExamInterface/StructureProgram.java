package ExamInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StructureProgram {
	// 사용자입력IO
	static Scanner scan = new Scanner(System.in);
	static Battery battery;
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 점수배열
		ExamConsole list = new ExamConsole();
//		ExamList list = new ExamList();

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			// 메뉴 출력
			list.printMenu();
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
			case 4:
				// 배터리 호출
//				battery.getEnergy();
				FileInputStream fis = new FileInputStream("src/ExamInterface/config.txt");
				scan = new Scanner(fis);
				String className = scan.next();
				System.out.println(className);
				
				scan = new Scanner(System.in);
				fis.close();
				
				Class cl = Class.forName(className);				
				X x = (X) cl.newInstance();
				A a = new A(x);
//				a.setX(x);
				a.print();
				break;
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}
	}

	
}