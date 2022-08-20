package chap09;

public class Sample03 {
    public static void main(String[] args) {
        ElectricCar car1 = new ElectricCar("red", "Hyundai");
        car1.printInfo();
        car1.setColor("Gray");

        GasolineCar car2 = new GasolineCar("blue", "Kia");
        car2.printInfo();
    }
}
