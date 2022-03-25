package ch24;

import java.util.ArrayList;

public class Student {

	String studentName;
	int studentId;
	ArrayList<Subject> subjectList;

	public Student(String studentName, int studentId) {
		this.studentName = studentName; 
		this.studentId = studentId;

		subjectList = new ArrayList<Subject>();
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		
		subject.setName(name);
		subject.setScorePoint(score);
		subjectList.add(subject);
	}
	
	public void showScoreInfo() {
		int total = 0;
		int average = 0;
		
		for(Subject subject : subjectList) {
			total += subject.getScorePoint();
			average = total / subjectList.size();
			System.out.println(studentName + "학생의 " + subject.getName() + "과목의 성적은 " + subject.getScorePoint() + "점 입니다.");
		}
		
		System.out.println(studentName + "학생의 총점은 " + total + "점이고 평균은 " + average + "점 입니다.");
		System.out.println("==========");
	}
}
