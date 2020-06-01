package exam01;

public class DmbCellPhone extends CellPhone{
	int channel = 0;
	
	public DmbCellPhone() {
		System.out.println("DmbCellPhone 생성");
	}

	public DmbCellPhone(int channel) {
		this.channel = channel;
		System.out.println("DmbCellPhone Channel 생성");
	}

	@Override
	void powerOn() {
		// TODO Auto-generated method stub
		super.powerOn();
		System.out.println("Dmb!!");
	}

}
