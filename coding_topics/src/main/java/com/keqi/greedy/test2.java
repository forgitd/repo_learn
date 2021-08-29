package com.keqi.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        int begin = nums[0];
        int answer = 1;
        for (int num : nums) {
            if (num - begin > k) {
                answer++;
                begin = num;
            }
        }
        System.out.println(answer);
    }
}
