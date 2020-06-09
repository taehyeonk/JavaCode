package exam01;

public class NumberFormatExceptionExample {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		int v1 = Integer.parseInt(data1);
		int v2 = Integer.parseInt(data2);
	}
}
