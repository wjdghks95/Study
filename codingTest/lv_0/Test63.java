package lv_0;

/*
    팩토리얼
        i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
        예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
        정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
 */
public class Test63 {
    public static void main(String[] args) {
        int n = 7;
        int solution = new Solution63().solution(n);
        System.out.println("solution = " + solution);
    }
}

class Solution63 {
    public int solution(int n) {
        int answer = 0;
        int i = 1, result = 1;
        while (result < n) {
            result *= i;
            i++;
        }
        if (result == 1) {
            answer = 1;
        } else if (result == n) {
            answer = i - 1;
        } else {
            answer = i - 2;
        }

        return answer;
    }
}


//  모범답안

/*
class Solution {
    public int solution(int n) {
        int fac = 1;
        int i = 0;

        while(true){
            if(fac <= n){
                fac *= i + 1;
                i++;
            }else break;
        }

        return i-1;
    }
}
 */