package exam01;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("일회용 전원 On");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("일회용 전원 Off");
			}
			
			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				System.out.println("볼륨조정");
			}
		};
		
		rc.turnOn();
		rc.turnOff();
		
	}
}
