package lv_0;

/*
    합성수 찾기
        약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
        자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
 */
public class Test59 {
    public static void main(String[] args) {
        int n = 10;
        int solution = new Solution59().solution(n);
        System.out.println("solution = " + solution);
    }
}

/*
    에라토스테네스의 체 알고리즘
        고대 그리스 수학자 에라토스테네스가 발견한 제곱근을 이용한 소수를 구하는 방법.
        소수를 구하는 최적의 알고리즘이라고 합니다.
        소수는 n의 배수가 아니고 입력받은 수를 그 수보다 작은 수들로 나누어서 떨어지면 소수가 아니다.
        그러므로, 모두 나누어 볼 필요없이 n 제곱근 까지만 나누어서 떨어지면 소수가 아니다.
 */
class Solution59 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) { // 입력받은 숫자까지의 모든 숫자들을 배열에 초기화한다. -> [0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) { // 제곱근까지만 계산 -> 2 ~ 3
            if (arr[i] == 0) { // 0으로 초기화 되어있는 숫자들은 건너뛴다.
                continue;
            }
            for (int j = i + i; j <= n; j += i) { // 현재 숫자(i)를 제외한 제곱수들은 모두 0으로 초기화 -> i=2: [0, 0, 2, 3, 0, 5, 0, 7, 0, 9, 0], i=3: [0, 0, 2, 3, 0, 5, 0, 7, 0, 0, 0]
                arr[j] = 0; // 0이 들어있는 번지는 소수가 아니다.
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) { // 0이 들어있는 번지가 합성수
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
    public int solution(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2).count();
    }
}
 */