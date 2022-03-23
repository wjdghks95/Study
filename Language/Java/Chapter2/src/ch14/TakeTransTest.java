package ch14;

public class TakeTransTest {

	public static void main(String[] args) {

		Student studentJ = new Student("James", 5000);
		Student studentT = new Student("Tomas", 10000);
		Student studentE = new Student("Edward", 20000);
		
		Bus bus100 = new Bus(100);
		Subway greenSubway = new Subway(10);
		Taxi jalnagandaTaxi = new Taxi("잘 나간다 운수");
		
		studentJ.takeBus(bus100);
		studentT.takeSubway(greenSubway);
		studentE.takeTaxi(jalnagandaTaxi);
		
		studentJ.showStudentInfo();
		studentT.showStudentInfo();
		studentE.showStudentInfo();
		
		bus100.showBusInfo();
		greenSubway.showBusInfo();
		jalnagandaTaxi.showTaxiInfo();
		
	}

}
