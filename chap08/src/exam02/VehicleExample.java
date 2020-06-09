package exam02;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		
		if(vehicle instanceof Bus) {
			System.out.println("버스");
		}
		else if(vehicle instanceof Car) {
			System.out.println("승용차");
		}
		
//		Bus bus = (Bus) vehicle;
//		
//		bus.run();
//		bus.checkFare();
	}
}
