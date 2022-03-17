
public class EqualsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String p1 = "java";
		String p2 = "java";
		
		String o1 = new String("java");
		String o2 = new String("java");
		
		System.out.println(p1 == p2);
		System.out.println(o1 == o2);
		System.out.println(o1.equals(o2));
		
	}

}
