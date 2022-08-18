package chap05;

import java.util.Arrays;

public class ArrayBinarySearchTest {
    public static void main(String[] args) {
        var students = new String[] {
                "스노우 화이트", "멀린", "레지나", "애버러지", "잭", "아더", "한스"
        };

        // 레드슈즈 주인공 '스노우 화이트'를 검색
        var sortedStudents = Arrays.copyOf(students, students.length);
        Arrays.sort(sortedStudents);

        int idx = Arrays.binarySearch(sortedStudents, "스노우 화이트");
        System.out.println(Arrays.toString(sortedStudents));
        System.out.printf("%d 번째 [%s]가 위치합니다.", (idx + 1), sortedStudents[idx]);
    }
}
