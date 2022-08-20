package chap09;

public class Sample01 {
    public static void main(String[] args) {
        ElectricCar car1 = new ElectricCar("red", "Hyundai");
        car1.printInfo();

        GasolineCar car2 = new GasolineCar("blue", "Kia");
        car2.printInfo();
    }
}
