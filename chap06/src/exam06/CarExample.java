package exam06;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		//myCar.speed = 9;
		myCar.setSpeed(360);
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
	}
}