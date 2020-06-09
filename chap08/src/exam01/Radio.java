package exam01;

public class Radio implements RemoteControl {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("라디오 On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("라디오 Off");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		RemoteControl.super.setMute(mute);
		System.out.println("Radio Mute");
	}
	
	
	
}
