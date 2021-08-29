/*
3 3 7
1 2 3
3 2 1
2 3 2
1 2 3
5 4 2
2 1 2
 */


package com.keqi.traceback;

import java.util.*;

public class test1 {
    private static int[][] w = new int[100][100]; // wij  重量
    private static int[][] c = new int[100][100]; // cij  价格
    private static int[] bestx = new int[100];    // 存放第i个零件的供应商，一次搜索到底后的最优解
    private static int[] x = new int[100];        // 临时存放第i个零件的供应商
    private static int cw = 0, cc = 0, bestw = 10000;
    private static int cost;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        cost = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                c[i][j] = scanner.nextInt();
            }
        }

        Backtrack(1);

        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                System.out.print(" ");
            }
            System.out.print(bestx[i]);
        }
        System.out.println();
        System.out.println(bestw);
    }

    public static void Backtrack(int t) {
        int j;
        if (t > n) {  //搜索到叶子结点，一个搜索结束，所有零件已经找完
            bestw = cw;  //当前最小重量
            for (j = 1; j <= n; j++) {
                bestx[j] = x[j];
            }
        } else {
            for (j = 1; j <= m; j++) {
                if (cc + c[t][j] <= cost && cw + w[t][j] < bestw) {
                    x[t] = j;
                    cc += c[t][j];
                    cw += w[t][j];
                    Backtrack(t + 1);
                    cc -= c[t][j];
                    cw -= w[t][j];
                }
            }
        }
    }
}

