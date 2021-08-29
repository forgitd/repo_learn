package com.keqi.divide_and_conquer;

import java.util.Scanner;

/**
 * 题目内容：
 *  设计分治算法实现将字符数组A[n]中所有元素循环左移k个位置,例如，对abcdefgh循环左移3位得到defghabc。
 *
 * 输入格式:
 *  第一行为数组长度n
 *  第二行为循环左移数k
 *  第三行为数组中元素
 *
 * 输出格式：
 *  循环左移k个位置后的结果
 *
 * 输入样例：
 * 8
 * 3
 * abcdefgh
 *
 * 输出样例：
 * defghabc
 */

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int str_len = scanner.nextInt();
        int i = scanner.nextInt();
        String str= scanner.next();

        /*char[] chars = new char[str_len];*/
        char[] s = str.toCharArray();
        // 普通
        /*for (int j = i; j < str_len; j++) {
            chars[j - i] = s[j];
        }
        for (int j = 0; j < i; j++) {
            chars[str_len - i + j] = s[j];
        }
        for (char c : chars) {
            System.out.print(c);
        }*/
        LeftReverse(s,0,i - 1);
        LeftReverse(s,i,str_len - 1);
        LeftReverse(s,0,str_len - 1);
        for (char c : s) {
            System.out.print(c);
        }
    }

    public static void LeftReverse(char[] a, int start, int end) {
        for (int i = 0; i < (end - start + 1)/2; i++) {
            char temp = a[end - i];
            a[end - i] = a[start + i];
            a[start + i] = temp;
        }
    }
}

/*
  cba hgfed
  defghabc
 */