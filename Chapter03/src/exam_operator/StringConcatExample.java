package exam_operator;

public class StringConcatExample {
	public static void main(String[] args) {
		String str1 = "JDK" + 6.0;
		System.out.println(str1);
		
		String str2 = 4 + 3 + "jdk";
		System.out.println(str2);
		
		
		// 먼저 계산되는 자료형에 따라 결과값이 다름
		// char + int 일 경우 결과값은 int값이 char형으로 변환되어 연산됨
	}
}
