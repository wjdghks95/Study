package chap02;

public class VarTest {
    public static void main(String[] args) {
//        var i = 365; // int i = 365;
//        System.out.println(i);
//
//        var j = 55L; // long j = 55L;
//        System.out.println(j);
//
//        Map<String, String> map = new HashMap<>();
//        var map2 = new HashMap<String, String>();
//        System.out.println(map2.toString());

//        var name; // 자료형을 추론할 때 리터럴이 없으면 추론할 수 없어서 에러 발생
        var name = "나어뗴";
        var age = 28;
        var height = 183.7f;
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("키 : " + height);
    }
}
