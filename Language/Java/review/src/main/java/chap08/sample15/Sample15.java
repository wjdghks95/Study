package chap08.sample15;

public class Sample15 {
    public static void main(String[] args) {
        Student.Score studentScore = new Student.Score("빵형");
        studentScore.eng = 23;
        studentScore.mat = 21;
        studentScore.showInfo();
    }
}
