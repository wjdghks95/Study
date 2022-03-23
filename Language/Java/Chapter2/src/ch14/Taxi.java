package ch14;

public class Taxi {

	String companyName;
	int income;
	int price;
	
	public Taxi(String companyName) {
		this.companyName = companyName;
		this.price = 10000;
	}
	
	public void take() {
		income += price;
	}
	
	public void showTaxiInfo() {
		System.out.println(companyName + " 택시의 수입은 " + income + "원 입니다.");
	}
}
