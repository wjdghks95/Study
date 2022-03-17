
public class ArrayApp {

	public static void main(String[] args) {
		
//		String users = "egoing, jinhuck, youbin";
		String[] users = new String[3];
		users[0] = "egoing";
		users[1] = "jinhuck";
		users[2] = "youbin";

		System.out.println(users[0]);
		System.out.println(users.length);
		
		int[] scores = {10, 100, 100};
		System.out.println(scores[1]);
		System.out.println(scores.length);
	}

}