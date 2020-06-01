package exam01;

public class CalExample {
	public static void main(String[] args) {
		Cal cal = new Cal();
		
		int i = cal.add(32, 34);
		System.out.println(i);
		System.out.println(cal.add(9.3, 2.1));
		System.out.println(cal.add("1", "4"));
	}
}
