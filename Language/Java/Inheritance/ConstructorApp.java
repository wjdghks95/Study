class Ca {
	int v1, v2;
	Ca(int v1, int v2) {
		System.out.println("Ca init!!");
		this.v1 = v1; this.v2 = v2;
	}
	public int sum() {
		return this.v1+v2;
	}
}
class Ca3 extends Ca {

	Ca3(int v1, int v2) {
		super(v1, v2);
		System.out.println("Ca3 init!!");
		
	}
	public int minus() {
		return this.v1-v2;
	}

}

public class ConstructorApp {

	public static void main(String[] args) {
		
		Ca c = new Ca(2, 1);
		Ca3 c3 = new Ca3(2, 1);
		System.out.println(c3.sum());
		System.out.println(c3.minus());
		
	}

}
