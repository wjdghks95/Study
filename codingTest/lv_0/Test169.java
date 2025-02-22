package lv_0;

/**
 * 안전지대
 * 문제 설명
 * 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
 * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
 * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * board는 n * n 배열입니다.
 * 1 ≤ n ≤ 100
 * 지뢰는 1로 표시되어 있습니다.
 * board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
 *
 * 입출력 예
 * board	result
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	16
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13
 * [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
 */
public class Test169 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        int solution = new Solution().solution(board);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int[][] board) {
            int answer = 0;
            int[][] newBoard = new int[board.length + 2][board.length * 3];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 1) {
                        for (int k = i; k <= i + 2; k++) {
                            for (int l = j + board[i].length - 1; l <= j + board[i].length + 1; l++) {
                                newBoard[k][l] = 1;
                            }
                        }
                    }
                }
            }

            answer = (int) Math.pow(board.length, 2);
            for (int i = 1; i < newBoard.length - 1; i++) {
                for (int j = board.length; j < newBoard[i].length - board.length; j++) {
                    if (newBoard[i][j] == 1) {
                        answer--;
                    }
                }
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(int[][] board) {
            int answer = 0;
            int length = board.length;   //길이
            int[][] temp = new int[length+2][length+2];
            // 길이를 2 늘린 액자용 배열 생성 -> 이러면 단순한 조건식으로 안전영역 구할 수 있음

            // 액자에 board 이식.
            for(int i=1; i<length+1; i++){
                for(int j=1; j<length+1;j++){
                    temp[i][j]=board[i-1][j-1];
                }
            }



            //위험지대 찾기
            for(int i=1; i<length+1; i++){
                for(int j=1; j<length+1;j++){
                    if(temp[i][j]==1){
                        for(int a = i-1; a<=i+1; a++){
                            for(int b =j-1; b<=j+1; b++){
                                if(temp[a][b]!=1) temp[a][b]=2;
                            }
                        }
                    }
                }
            }

            // 안전지대 카운트
            for(int i=1; i<length+1; i++){
                for(int j=1; j<length+1;j++){
                    if(temp[i][j]==0) answer++;
                    System.out.print(temp[i][j]);
                }
                System.out.println("");
            }


            return answer;
        }
    }
 */