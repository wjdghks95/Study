package lv_0;

/*
    369게임
        머쓱이는 친구들과 369게임을 하고 있습니다.
        369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
        머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.
 */
public class Test58 {
    public static void main(String[] args) {
        int order = 29423;
        int solution = new Solution58().solution(order);
        System.out.println("solution = " + solution);
    }
}

class Solution58 {
    public int solution(int order) {
        int answer = 0;
        char[] chars = String.valueOf(order).toCharArray();
        for (char c : chars) {
            if (c != '0' && c % 3 == 0) {
                answer++;
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
    public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split("")).map(Integer::parseInt).filter(i -> i == 3 || i == 6 || i == 9).count();
    }
}
 */