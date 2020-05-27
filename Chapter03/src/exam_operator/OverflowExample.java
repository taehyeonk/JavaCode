package exam_operator;

public class OverflowExample {
	public static void main(String[] args) {
		int x = 1000000;
		int y = 1000000;
		int z = x*y;
		System.out.println(z);
		
		byte x1 = 127;
		byte y1 = (byte) (x1+2);
		System.out.println(y1);
	}
}
