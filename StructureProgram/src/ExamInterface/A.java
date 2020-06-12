package ExamInterface;

public class A {

	X x;
	public A(X x) {
		this.x = x;
	}
	public X getX() {
		return x;
	}

	public void setX(X x) {
		this.x = x;
	}

	public void print() {
//		B b = new B();
//		C c = new C();
		
		System.out.println(x.getTotal());

	}

}
