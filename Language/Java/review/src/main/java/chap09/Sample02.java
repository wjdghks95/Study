package chap09;

public class Sample02 {
    public static void main(String[] args) {
        Car car1 = new ElectricCar("red", "Hyundai");
        car1.printInfo();
//        car1.stColor("Gray");

        GasolineCar car2 = new GasolineCar("blue", "Kia");
        car2.printInfo();
    }
}
