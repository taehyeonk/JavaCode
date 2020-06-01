package exam01;

public class Car {
	//고유 데이터
	String model;
	String company;
	String color;
	int maxSpeed;
	
	//상태
	int speed;
	int rpm;
	int direction; // + : 우측 , - : 좌측, 0 : 직진
	boolean state = false; // 시동이 걸려 있는지에 대한 여부
	boolean automode = false;// false면  작동안함
	
	int mynum;
	static int number = 0;
	
	//기능	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String company) {
		super();
		this.company = company;
	}

	public Car(String model, String company, String color, int maxSpeed, int speed, int rpm, int direction,
			boolean state, boolean automode, int mynum) {
		super();
		this.model = model;
		this.company = company;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
		this.rpm = rpm;
		this.direction = direction;
		this.state = state;
		this.automode = automode;
		this.mynum = mynum;
	}

	void automodeOn() {
		automode = true;
	}

	void automodeOff() {
		automode = false;
	}
	
	void startOn() { // 시동 켜기
		state = true;
	}
	
	void startOff() { // 시동 끄기
		state = false;
	}
	
	int go_foward() { // 전진 이동
		return 1;
	}
	
	int go_backward() { // 후진 이동
		return -1;
	}
	
	int stop() { // 이동 정지
		return 0;
	}
	
	void speed_up(int value) {
		speed += value;
	}
	
	void speed_down(int value) {
		speed -= value;
	}
	
	void go_straight () {
		if(direction != 0) {
			direction = 0;
		}
	}
	
	void go_right() {
		if(direction < 0) { // 음수이면 = 좌측방향 진행중이면
			direction = -1;
		}		
	}
	
	void go_left() {
		if(direction > 0) { // 양수이면 = 우측방향 진행중이면
			direction = -1;
		}
	}
	
	int sum(int ... values) {
		int result = 0;
		for(int value : values) {
			result += value;
		}
		return result;
	}
}

class Cellphone {
	// 고유 데이터
	String OS;
	String Model;
	String Brand;
	String color;
	
	int inch;
	int[] px_num;
	
	
	//상태
	
}

class Tire {
	
}