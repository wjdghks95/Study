
public class LoopArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] users = new String[3];
		users[0] = "egoing";
		users[1] = "jinhuck";
		users[2] = "youbin";
		
		for(int i=0; i<users.length; i++) {
			if(i < users.length-1) {
				System.out.println(users[i]+",");
			} else if(i < users.length) {
				System.out.println(users[i]+".");
			}
			
		}

	}

}
