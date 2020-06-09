package exam04;

public abstract class Phone {
	public String owner;

	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("폰 전원 on");
	}
	
	public void turnOff() {
		System.out.println("폰 전원 off");
	}
	
	public abstract void bellOn();
}
