package exam02;

public class Test {
	public static void main(String[] args) {
		Object obj = new Object();
		
		System.out.println(obj);
		
		System.out.println(obj.hashCode());
		
		System.out.println(Integer.toHexString(obj.hashCode()));
	}
}
