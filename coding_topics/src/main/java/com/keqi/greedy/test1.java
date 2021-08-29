package com.keqi.greedy;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 牛数量
        int[][] time = new int[2][n];
        for (int i = 0; i < n; i++) {
            time[0][i] = scanner.nextInt();
            time[1][i] = scanner.nextInt();
        }
        int cl[] = new int[n];
        int ccl[] = new int[n];
        for (int i = 0; i < n; i++) {
            ccl[i] = 0;
        }
        int j = 0;
        int min = 0;  // 最少畜栏数量
        for (; j < n; j++) { // 循环  牛
            for (int i = 0; i < n; i++) {  // 循环畜栏
                if (time[0][j] > ccl[i]) {
                    cl[j] = i + 1;
                    if (cl[j] > min) {
                        min = cl[j];
                    }
                    ccl[i] = time[1][j];
                    break;
                }
            }
        }
        System.out.println(min);
        for (int i : cl) {
            System.out.println(i);
        }
    }
}
