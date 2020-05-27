package exam_operator;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;
		double z = x / y;
		
		System.out.println(z);
		
		if(Double.isInfinite(z) == true) {
			System.out.println("무한대입니다");
		}
	}
}
