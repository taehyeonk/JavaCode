package exam01;

public class Cal {
	double result;
	
	int add(int a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}
	
	int add(String a, String b) {
		return Integer.parseInt(a) + Integer.parseInt(b);
	}
}
