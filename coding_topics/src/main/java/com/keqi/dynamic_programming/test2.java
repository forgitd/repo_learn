/**
 * 题目内容：
 * 两种水果杂交出一种新水果，现在给新水果取名，要求这个名字中包含以前两种水果的字母，且名字尽量短，即：以前的水果名字arr1、arr2是新水果名arr的子序列，使用动态规划的思想设计算法得到新水果名arr。

 * 输入格式:
 * 以空格分开两个水果的名字
 *
 * 输出格式：
 * 新水果的名字
 *
 * 输入样例：
 * pear peach
 *
 * 输出样例：
 * pearch
 *
 * 输入样例：
 * peach pear
 *
 * 输出样例：
 * peachr
 */
package com.keqi.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    private static String s1,s2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s1 = scanner.next();
        s2 = scanner.next();

        newName(s1, s2);
        System.out.println("");
    }

    public static void newName(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int[][] comp = new int[m + 1][n + 1];
        findLCS(dp, comp);
        display(m, n, comp);

    }

    public static void findLCS(int[][] dp,int[][] comp) {

        // 边界条件
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);

        //遍历arr1和arr2的所有字符
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //比较的字符相同,comp置为0
                if (s1.charAt(i - 1) == s2.charAt(j - 1) ) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    comp[i][j] = 0;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    //dp当前方格上方的方格大于左侧的方格，comp置为1
                    dp[i][j] = dp[i - 1][j];
                    comp[i][j] = 1;
                } else {
                    //dp当前方格上方的方格小于等于左侧的方格,comp置为2
                    dp[i][j] = dp[i][j - 1];
                    comp[i][j] = 2;
                }
            }
        }
    }

    public static void display(int i,int j,int[][] comp) {

        if (i == 0 && j == 0) {
            return;
        }
        if (i == 0) {
            display(i, j - 1, comp);
            System.out.print(s2.charAt(j - 1));
            return;
        } else if (j == 0) {
            display(i - 1, j, comp);
            System.out.print(s1.charAt(i - 1));
            return;
        }

        if (comp[i][j] == 0) {
            display(i - 1, j - 1, comp);
            System.out.print(s1.charAt(i - 1));
        } else if (comp[i][j] == 1) {
            display(i - 1, j, comp);
            System.out.print(s1.charAt(i - 1));
        } else {
            display(i, j - 1, comp);
            System.out.print(s2.charAt(j - 1));
        }
    }

}
