package lv_0;

/*
    k의 갯수
        1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
        정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.

        제한사항
        1 ≤ i < j ≤ 100,000
        0 ≤ k ≤ 9
 */
public class Test66 {
    public static void main(String[] args) {
        int i = 1;
        int j = 13;
        int k = 1;
        int solution = new Solution66().solution(i, j, k);
        System.out.println("solution = " + solution);
    }
}

class Solution66 {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int s = i; s <= j; s++) {
            char[] array = String.valueOf(s).toCharArray();
            for (char c : array) {
                if (Character.getNumericValue(c) == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public int solution(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}
 */
