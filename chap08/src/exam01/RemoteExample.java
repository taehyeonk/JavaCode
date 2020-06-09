package exam01;

public class RemoteExample {
	public static void main(String[] args) {
		Television tv = new Television();
		Radio rd = new Radio();
		Searchable1 rc = new Television1();
		
		rc.turnOn();
		rc.turnOff();
		rc.setMute(true);
		
		rc.search1("url");
	}
}
