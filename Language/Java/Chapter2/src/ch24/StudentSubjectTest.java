package ch24;

public class StudentSubjectTest {

	public static void main(String[] args) {

		Student studentLee = new Student("Lee", 1001);
		
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);
		
		Student studentKim = new Student("Kim", 1002);
		
		studentKim.addSubject("국어", 70);
		studentKim.addSubject("수학", 85);
		studentKim.addSubject("영어", 100);
		
		studentLee.showScoreInfo();
		studentKim.showScoreInfo();
	}

}
