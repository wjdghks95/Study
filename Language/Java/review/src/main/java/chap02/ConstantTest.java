package chap02;

public class ConstantTest {
    public static void main(String[] args) {
        final float PI; // 초기값을 정하지 않고 PI를 상수로 선언
        PI = 3.14f; // 최초값을 선언, 이후 PI 값 변경시 오류 발생
//        PI = 3.141592f; // Variable 'PI' might already have been assigned to

//        final var PI2; // = 3.141592f;

        int radius = 10;

        float area = radius * radius * PI;
        System.out.printf("원의 넓이 : %f", area);
    }
}
