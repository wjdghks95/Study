package ch12;

public class MemberHashSetTest {

	public static void main(String[] args) {
		
		MemberHashSet MemberHashSet = new MemberHashSet();
		
		Member memberLee = new Member(1001, "이순신");
		Member memberKim = new Member(1002, "김유신");
		Member memberKang = new Member(1003, "강감찬");
		
		MemberHashSet.addMember(memberLee);
		MemberHashSet.addMember(memberKim);
		MemberHashSet.addMember(memberKang);
		
		Member memberHong = new Member(1003, "홍길동");
		MemberHashSet.addMember(memberHong);
		
		MemberHashSet.showAllMember();
	}

}
