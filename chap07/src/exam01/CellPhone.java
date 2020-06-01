package exam01;

public class CellPhone {
	String model;
	String color;
	
	public CellPhone() {
		System.out.println("CellPone 생성");
	}
	
	public CellPhone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	void powerOn() {
		System.out.println("전원 On");
	}
}
