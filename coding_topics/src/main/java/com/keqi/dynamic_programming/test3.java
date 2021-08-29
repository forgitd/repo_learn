/**
 * 题目内容：
 * 一个机器人只能向下和向右移动，每次只能移动一步，设计一个算法求机器人从（1,1）到（m，n）有多少条路径。

 * 输入格式:
 * 以空格分开m，n
 *
 * 输出格式：
 * 路径条数
 *
 * 输入样例：
 * 4 5
 *
 * 输出样例：
 * 35
 */
package com.keqi.dynamic_programming;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(sumOfPath(m, n));
    }

    public static int sumOfPath(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        // 只能往右 下移动
        // 所以边界 路径条数为1
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 只能往右 下移动，这个点的路径总数等于到达左边和上面的点的路径之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
