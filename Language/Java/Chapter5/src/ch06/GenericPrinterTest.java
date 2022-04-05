package ch06;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
		Powder powder = new Powder();
		powderPrinter.setMaterial(powder);
		
		Powder p1 = powderPrinter.getMaterial();
		System.out.println(p1.toString());
		
		Plastic plastic = new Plastic();
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		plasticPrinter.setMaterial(plastic);
		
		Plastic p2 = plasticPrinter.getMaterial();
		System.out.println(p2.toString());
	}

}
