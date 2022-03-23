package ch14;

public class Bus {

	int busNumber;
	int income;
	int price;
	int passenger;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
		this.price = 1000;
	}
	
	public void take() {
		income += price;
		passenger++;
	}
	
	public void showBusInfo() {
		System.out.println(busNumber + "번 버스의 승객 수는 " + passenger + "명 이고, 수입은 " + income + "원 입니다.");
	}
}
