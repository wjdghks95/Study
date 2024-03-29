package chap05;

public class MultiDimensionalArrayTest {
    public static void main(String[] args) {
        int[][] household = new int[5][3];
        household[1] = new int[1];
        System.out.printf("1층 %d 세대\n", household[0].length);
        System.out.printf("2층 %d 세대\n", household[1].length);
        System.out.printf("3층 %d 세대\n", household[2].length);
        System.out.printf("4층 %d 세대\n", household[3].length);
        System.out.printf("5층 %d 세대\n", household[4].length);

        int[][][] household2 = {
                {
                        {1, 2, 3}, {4, 5, 6}, {7}, {8, 9 , 10}, {11, 12, 13}
                },
                {
                        {14, 15, 16}, {17, 18, 19}, {20}, {21, 22 , 23}, {24, 25, 26}
                }
        };
        System.out.printf("1동 1층 1세대 : %d\t", household2[0][0][0]);
        System.out.printf("1동 1층 2세대 : %d\t", household2[0][0][1]);
        System.out.printf("1동 1층 3세대 : %d\t\n", household2[0][0][2]);

        System.out.printf("1동 2층 1세대 : %d\t", household2[0][1][0]);
        System.out.printf("1동 2층 2세대 : %d\t", household2[0][1][1]);
        System.out.printf("1동 2층 3세대 : %d\t\n", household2[0][1][2]);

        System.out.printf("1동 3층 1세대 : %d\t\n", household2[0][2][0]);

        System.out.printf("1동 4층 1세대 : %d\t", household2[0][3][0]);
        System.out.printf("1동 4층 2세대 : %d\t", household2[0][3][1]);
        System.out.printf("1동 4층 3세대 : %d\t\n", household2[0][3][2]);

        System.out.printf("1동 5층 1세대 : %d\t", household2[0][4][0]);
        System.out.printf("1동 5층 2세대 : %d\t", household2[0][4][1]);
        System.out.printf("1동 5층 3세대 : %d\t\n", household2[0][4][2]);

        System.out.printf("2동 1층 1세대 : %d\t", household2[1][0][0]);
        System.out.printf("2동 1층 2세대 : %d\t", household2[1][0][1]);
        System.out.printf("2동 1층 3세대 : %d\t\n", household2[1][0][2]);

        System.out.printf("2동 2층 1세대 : %d\t", household2[1][1][0]);
        System.out.printf("2동 2층 2세대 : %d\t", household2[1][1][1]);
        System.out.printf("2동 2층 3세대 : %d\t\n", household2[1][1][2]);

        System.out.printf("2동 3층 1세대 : %d\t\n", household2[1][2][0]);

        System.out.printf("2동 4층 1세대 : %d\t", household2[1][3][0]);
        System.out.printf("2동 4층 2세대 : %d\t", household2[1][3][1]);
        System.out.printf("2동 4층 3세대 : %d\t\n", household2[1][3][2]);

        System.out.printf("2동 5층 1세대 : %d\t", household2[1][4][0]);
        System.out.printf("2동 5층 2세대 : %d\t", household2[1][4][1]);
        System.out.printf("2동 5층 3세대 : %d\t\n", household2[1][4][2]);
    }
}
