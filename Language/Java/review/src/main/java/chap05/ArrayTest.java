package chap05;

public class ArrayTest {
    public static void main(String[] args) {
        int sut1_kor_score = 0; // 국어 점수
        int sut1_eng_score = 0; // 영어 점수
        int sut1_mat_score = 0; // 수학 점수
        int sut1_sci_score = 0; // 과학 점수

        int sut2_kor_score = 0; // 국어 점수
        int sut2_eng_score = 0; // 영어 점수
        int sut2_mat_score = 0; // 수학 점수
        int sut2_sci_score = 0; // 과학 점수

        int[] kor_score = new int[3];
        kor_score[0] = 10;
        kor_score[1] = 20;
        kor_score[2] = 30;
        System.out.printf("배열의 갯수는 %d개 입니다.\n", kor_score.length);

        int[] number = {10, 20, 30, 40};
        System.out.printf("배열의 갯수는 %d개 입니다.\n", number.length);

        String[] str1 = new String[3];
        str1[0] = "자바";
        str1[1] = "코틀린";
        str1[2] = "씨";
        System.out.printf("str1 배열의 갯수는 %d개 입니다.\n", str1.length);

        String[] str2 = {"자바", "코틀린", "씨"};
        System.out.printf("str2 배열의 갯수는 %d개 입니다.\n", str2.length);

        String[] str3 = str2.clone();
        System.out.println(str3[0]);
        System.out.println(str3[1]);
        System.out.println(str3[2]);
    }
}
