package exam_operator;

import java.util.Scanner;

public class AppleBox {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int apple_num = scanner.nextInt();
		int group_num = 12;
		
		System.out.println("총 사과 " + apple_num + "개에 " + group_num + "개당 1박스를 제작하면,");	
		System.out.println("사과박스 " + (int)(apple_num/group_num) + "개에 나머지 " + apple_num%group_num + "개가 남는다");
	}
}
