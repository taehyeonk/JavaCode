package exam02;

public class ThrowExample {
	public void method1() {
		try {
			method2();
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		} finally {
			System.out.println("finally 블록");
		}
	}
	
	public void method2() throws ClassNotFoundException {
		Class cl = Class.forName("java.lang.String2");
	}
}
