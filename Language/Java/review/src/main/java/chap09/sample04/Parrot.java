package chap09.sample04;

public class Parrot extends Pet{

    public Parrot(boolean wing, int legCount) {
        super(wing, legCount);
    }

    @Override
    public void run(String name) {
        System.out.printf("%s는 두발로 뜁니다.\n", name);
    }

    public void fly(String name) {
        System.out.printf("%s는 뛰지않고 날라갑니다.\n", name);
    }
}
