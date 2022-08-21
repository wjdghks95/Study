package chap10;

public class Sample07 {
    public static void main(String[] args) {
        Sample06<Integer> age = new Sample06<Integer>();
        Sample06<String> name = new Sample06<String>();

        var age2 = new Sample06<Integer>();

        age.setA(18);
        name.setA("빵형");

        int personAge = age.getA();
        String personName = name.getA();

        System.out.printf("%s은 %d살", personName, personAge);
    }
}
