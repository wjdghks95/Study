package ch07;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
		Powder powder = new Powder();
		powderPrinter.setMaterial(powder);
		
		Powder po = powderPrinter.getMaterial();
		System.out.println(po.toString());
		
		
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		Plastic plastic = new Plastic();
		plasticPrinter.setMaterial(plastic);
		
		Plastic pl = plasticPrinter.getMaterial();
		System.out.println(pl.toString());
		
//		GenericPrinter<Water> waterPrinter = new GenericPrinter<>();
		
	}

}
