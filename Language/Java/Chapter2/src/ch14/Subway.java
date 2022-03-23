package ch14;

public class Subway {

	int subwayNumber;
	int income;
	int price;
	int passenger;
	
	public Subway(int subwayNumber) {
		this.subwayNumber = subwayNumber;
		this.price = 1200;
	}
	
	public void take() {
		income += price;
		passenger++;
	}
	
	public void showBusInfo() {
		System.out.println(subwayNumber + "라인 지하철의 승객 수는 " + passenger + "명 이고, 수입은 " + income + "원 입니다.");
	}
}