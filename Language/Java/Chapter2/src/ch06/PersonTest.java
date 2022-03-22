package ch06;

public class PersonTest {

	public static void main(String[] args) {

		Person Tomas = new Person(180, 78, "남성", "Tomas", 37);
		Person Wendy = new Person(160, 50, "여성", "Wendy", 29);
		
		Tomas.showPersonInfo();
		Wendy.showPersonInfo();
	}

}
