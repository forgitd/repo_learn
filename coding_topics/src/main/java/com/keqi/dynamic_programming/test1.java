/**
 * 是以后每一发炮弹都不能高于前一发的高度
 *
 * 输入格式：
 * 第一行，输入雷达捕捉到的敌国导弹的数量k（k<=25），第二行，输入k个正整数，表示k枚导弹的高度，按来袭导弹的袭击时间顺序给出，以空格分隔。
 *
 * 输出格式：
 * 输出只有一行，包含一个整数，表示最多能拦截多少枚导弹。
 *
 * 输入样例：
 * 8
 * 300 207 155 300 299 170 158 65
 *
 * 输出样例：
 * 6
 */
package com.keqi.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(intercept(nums));
    }
    public static int intercept(int[] nums) {
        // dp记录当前i 的逆序炮弹数有多少，并不是记录最大逆序炮弹数量
        // 动态规划： 当当前i的高度小于上一个时，那么炮弹数为上一个的炮弹数+自己
        int[] dp = new int[nums.length];
        // 寻找i之前的 高度大于i的炮弹数
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            // 加上自己
            dp[i] = max + 1;
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }
//9
//300 207 155 300 299 170 158 65 400
}
