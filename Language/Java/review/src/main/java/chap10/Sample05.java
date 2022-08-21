package chap10;

public class Sample05 {
    public static void main(String[] args) {
        Sample04 age = new Sample04();
        Sample04 name = new Sample04();

        age.setA(18);
        name.setA("빵형");

        int personAge = (int) age.getA();
        String personName = (String) name.getA();

        System.out.printf("%s은 %d살", personName, personAge);
    }
}
