package lv_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 최빈값 구하기
 * 문제 설명
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
 *
 * 제한사항
 * 0 < array의 길이 < 100
 * 0 ≤ array의 원소 < 1000
 *
 * 입출력 예
 * array	result
 * [1, 2, 3, 3, 3, 4]	3
 * [1, 1, 2, 2]	-1
 * [1]	1
 */
public class Test161 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};
        int solution = new Solution().solution(array);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int[] array) {
            int answer = 0;

            Arrays.sort(array);
            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                List<Integer> nums = new ArrayList<>();
                nums.add(array[i]);
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        nums.add(array[j]);
                        i++;
                    }
                }
                list.add(nums);
            }

            int[] sizeList = list.stream().mapToInt(List::size).toArray();
            int max = Arrays.stream(sizeList).max().getAsInt();

            for (int i = 0; i < sizeList.length; i++) {
                if (sizeList[i] == max) {
                    answer = list.get(i).get(0);
                    for (int j = 0; j < sizeList.length; j++) {
                        if (i != j && sizeList[j] == max) {
                            answer = -1;
                        }
                    }
                }
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(int[] array) {
            int maxCount = 0;
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int number : array){
                int count = map.getOrDefault(number, 0) + 1;
                if(count > maxCount){
                    maxCount = count;
                    answer = number;
                }
                else  if(count == maxCount){
                    answer = -1;
                }
                map.put(number, count);
            }
            return answer;
        }
    }
 */

/*
    class Solution {
        public int solution(int[] array) {
            List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.groupingBy(o -> o)).entrySet()).stream().sorted((t0, t1) -> Integer.compare(t1.getValue().size(), t0.getValue().size())).collect(Collectors.toList());
            return list.size() > 1 && list.get(0).getValue().size() - list.get(1).getValue().size() == 0 ? -1 : list.get(0).getKey();
        }
    }
 */