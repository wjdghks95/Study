package ch14;

public class Student {

	String studentName;
	int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take();
		this.money -= bus.price;
	}
	
	public void takeSubway(Subway subway) {
		subway.take();
		this.money -= subway.price;
	}
	
	public void takeTaxi(Taxi taxi) {
		taxi.take();
		this.money -= taxi.price;
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + "님의 남은 돈은 " + money + "원 입니다.");
	}
}
