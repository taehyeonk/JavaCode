package exam01;

public class Television implements RemoteControl, Searchable {
	
	int volume;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("전원 On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("전원 Off");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		this.volume = volume;
	}

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println(url);
	}
	
}
