
public class WhyMethod {

	public static void main(String[] args) {
		
		printTwoTimes("a", "-");
		printTwoTimes("b", "*");
		printTwoTimes("c", "&" );
		
		System.out.println(twoTimes("a", "-"));

	}
	
	public static String twoTimes(String text, String delimiter) {
		String out = "";
		out = out + delimiter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		return out;
	}

	public static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}

}
