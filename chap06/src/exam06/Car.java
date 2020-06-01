package exam06;

public class Car {
	private int speed;
	private boolean stop;
	
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		if(speed >=0 && speed <= 350) {
			this.speed = speed;
			System.out.println("현재속도 : " + this.speed);
		}
		else {
			System.out.println("오류");
		}
	}
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", stop=" + stop + "]";
	}
	/**
	 * @return the stop
	 */
	public boolean isStop() {
		return stop;
	}
	/**
	 * @param stop the stop to set
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
