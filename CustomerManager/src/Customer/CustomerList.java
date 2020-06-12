package Customer;

public class CustomerList {
    // 배열에 저장할 수 있는 최대 고객의 수
    final int MAX = 100;
    // 고객정보를 저장할 변수를 배열로 선언
    Customer[] customer = new Customer[MAX];

    // 배열은 인덱스를 필요로 함
    int index = -1;// 배열은 0부터 시작하므로 최초 인덱스는 -1이어야 함
    
    // 배열은 처음 선언한 크기보다 같거나 적은 개수의 자료를 저장
    // 그래서 현재 데이터가 몇 개 저장되어있는 지 알 수 있는 변수 선언
    int count = 0;// 개수

    
	public int getMAX() {
		return MAX;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
