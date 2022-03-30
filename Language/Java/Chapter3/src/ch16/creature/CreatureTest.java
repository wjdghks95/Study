package ch16.creature;

public class CreatureTest {

	public static void main(String[] args) {

		Pigeon pigeon1 = new Pigeon(5, 10, 14);
		pigeon1.printInfo();
		pigeon1.age();
		pigeon1.move(100);
		pigeon1.fly(5);
		pigeon1.flyMove(10, 20);
		pigeon1.attack();
		pigeon1.printInfo();
		
		System.out.println("============");
		
		Kevin kevin = new Kevin(0, 0, 35);
		kevin.printInfo();
		kevin.age();
		kevin.move(10);
		kevin.attack();
		kevin.coding();
		kevin.swimDown(20);
		kevin.Talk();
		kevin.printInfo();
		
		System.out.println("============");
		
		Turtle turtle1 = new Turtle(100, -10, 95);
		turtle1.printInfo();
		turtle1.age();
		turtle1.move(-100);
		turtle1.attack();
		turtle1.swimDown(1000);
		turtle1.printInfo();
		
	}

}
