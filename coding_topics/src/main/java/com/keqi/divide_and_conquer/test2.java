package com.keqi.divide_and_conquer;

import java.util.Scanner;

/**
 * 题目内容：
 * <p>
 * 设a1, a2,…, an是集合{1, 2, …, n}的一个排列，如果i<j且ai>aj，则序偶(ai, aj)称为该排列的一个逆序。例如，2, 3, 1有两个逆序：(3, 1)和(2, 1)。设计算法统计给定排列中含有逆序的个数。
 * <p>
 * <p>
 * 输入格式:
 * 第一行输入集合中元素个数n，第二行输入n个集合元素
 * <p>
 * 输出格式：
 * 含有逆序的个数
 * <p>
 * 输入样例：
 * 3
 * 2 3 1
 * <p>
 * 输出样例：
 * 2
 */

public class test2 {
    private static int count = 0;
    private static int[] b = new int[1000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }

        mergeSort(nums, 0, len - 1);
        System.out.println(count);
    }

    public static void mergeSort(int[] a, int b, int e) {
        if (b < e) {
            int mid = (b + e) / 2;
            mergeSort(a, b, mid);
            mergeSort(a, mid + 1, e);
            merge(a, b, mid, e);
        }
    }

    // a 0 0 1
    public static void merge(int[] a, int begin, int mid, int end) {

        int l = begin, m = mid + 1, r = end, n = 0;

        while (l <= mid && m <= r) {
            if (a[l] <= a[m]) {
                b[n++] = a[l];
                l++;
            } else {
                b[n++] = a[m];
                m++;
                count += mid - l + 1;
            }
        }

        // 添加上一个循环中没有添加到b中的元素
        while (l <= mid) {
            b[n++] = a[l++];
        }
        while (m <= r) {
            b[n++] = a[m++];
        }

        // 归并排序：使用辅助数组b给a排序
        for (int i = 0; i < n; i++) {
            a[begin++] = b[i];
        }
    }
}
