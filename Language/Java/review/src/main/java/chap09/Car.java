package chap09;

public abstract class Car {
    protected String color;
    protected String manufacturer;

    public Car(String color, String manufacturer) {
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public void printInfo() {
        System.out.println("이 차의 색 : " + color);
        System.out.println("이 차는 : " + fillUp());
        System.out.println("이 차는 : " + manufacturer + "에서 생산합니다.");
    }

    public abstract String fillUp();
}
