package exam02;

public class BoxExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>(); // java7부터 new 선언 이후에는 <>안에 자료형 입력 안해도 됨
		box1.setT("hello");
		
		String str = box1.getT();
		System.out.println(str);
		
		Box<Integer> box2 = new Box<>();
		box2.setT(6);
		int value = box2.getT();
		System.out.println(value);
	}
}