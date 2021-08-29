package code822;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入两行
 * 2     数组长度
 * 1 2   数组
 * 求数组中元素是否可以经过*2操作变为一致
 * 数组中的元素为正整数
 */

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int[] nums = new int[i];
        for (int j = 0; j < i; j++) {
            nums[j] = scanner.nextInt();
        }
//        System.out.println(i);
//        System.out.println(Arrays.toString(nums));
        String res = check(nums);
        System.out.println(res);
    }
    public static String check(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return "YES";
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                float i1 = nums[j] / nums[i];
                if (i1 < 1) {
                    i1 = 1 / i1;
                }
                if (i1 != 2) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    // 满分方法
    public static String check1(int[] nums) {
        Float[] nums1 = new Float[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = Float.valueOf(nums[i]);
        }
        HashSet<Float> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            while (nums1[i] >= 2) {
                nums1[i] = nums1[i] / 2;
            }
            set.add(nums1[i]);
        }
        if (set.size() == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
