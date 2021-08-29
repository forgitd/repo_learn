/*
    第一行：输入总金钱money，商品数量n
    此后的n行：（每行代表一个商品，数值分别代表，商品价格、商品可买数量、商品喜爱值）
    商品价格 商品数量 商品喜爱值
    p1 n1 like1
    p2 n2 like2
    …
    问：如何购买能让喜爱值最大

    输入测试:
    9 5
    4 1 3
    2 2 2
    3 3 3
    4 4 6
    7 1 4
 */

import java.util.Scanner;

public class test1_up {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] food = new int[n][3];
        for (int i = 0; i < n; ++i) {
            food[i][0] = scanner.nextInt();
            food[i][1] = scanner.nextInt();
            food[i][2] = scanner.nextInt();
        }
        // 0 1背包问题，dp[x]表示选取x元零食可达到的最大喜爱度
        int[] dp = new int[x+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                 for (int k = 1; k <= food[j][1] ; k++) {
                    if (i - k * food[j][0] >= 0) {
                        dp[i] = Math.max(dp[i], dp[i - k * food[j][0]] + k * food[j][2]);
                    }
                }
            }
        }
        System.out.println(dp[x]);
    }
}
