
public class StringOperation {

	public static void main(String[] args) {
		
		System.out.println("Hello World".length()); // 11
		System.out.println("Hello, [[name]]... bye.".replace("[[name]]", "egoing"));
		System.out.println("Hello World".charAt(1)); // e
		System.out.println("Hello World".indexOf("o")); // 4
		System.out.println("Hello ".concat("World")); // Hello World

	}

}
