package com.keqi.traceback;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    private static int[] nums;
    private static boolean flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        PartialSum(0, k);
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
    public static void PartialSum(int i, int k) {
        if (k == 0) flag = true;
        if (i >= nums.length || flag) return ;
        PartialSum(i + 1, k - nums[i]);
        PartialSum(i + 1, k);
    }

//    public static boolean PartialSum(int[] nums, int k) {
//        Arrays.sort(nums);
//        int m;
//        for (int i = nums.length - 1; i >= 0 ; i--) {
//            if (k > nums[i] && k > 0) {
//                m = k - nums[i];
//                int[] nums1 = new int[nums.length - 1];
//                System.arraycopy(nums, 0, nums1, 0, i);
//                if (PartialSum(nums1, m)) {
//                    return true;
//                }
//            } else if (k == nums[i]) {
//                return true;
//            }
//        }
//        return false;
//    }

}
