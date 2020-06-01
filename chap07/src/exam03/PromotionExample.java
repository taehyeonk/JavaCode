package exam03;

public class PromotionExample {
	public static void main(String[] args) {
		A a = new A();
		A ab = new B();
		A ac = new C();
		A ad = new D();
		A ae = new E();
		
//		B ba = new A();
		B b = new B();
//		B bc = new C();
		B bd = new D();
//		B be = new E();
		
//		C ca = new A();
//		C cb = new B();
		C c = new C();
//		C cd = new D();
		C ce = new E();
		
//		D da = new A();
//		D db = new B();
//		D dc = new C();
		D d = new D();
//		D de = new E();
		
//		E ea = new A();
//		E eb = new B();
//		E ec = new C();
//		E ed = new D();
		E e = new E();
		
		B bb = (B) ab;
		
		ab.method();
		
		if(ac instanceof B) {
			System.out.println("B");
		} else {
			System.out.println("아님");
		}
				
	}
}
