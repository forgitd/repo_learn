import java.util.Arrays;
import java.util.Scanner;

/**
 * 给个数组，给个M，求数组中所有比M小的组合数
 *
 * 输入：
 * 7 -1 -1
 * 9
 * 输出：3
 * 因为7和第一个-1，7和第二个-1，第一个-1 和第二个-1
 */
public class test1_up {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        int m = scanner.nextInt();
        // 工具类输出数组
        /*System.out.println(Arrays.toString(nums));
        System.out.println(m);*/

        int res = sumBiggerM(nums, m);
        System.out.println(res);
    }

    /*
    // 1. 双循环，排除掉i j 相等的情况 （错误 7 -1 和 -1 7）
    // 2. 优化，代码排除了双层循环（普通情况）下对之间已经计算过的元素的重新计入
    // 3.
     */
    public static int sumBiggerM(int[] nums, int m) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= m) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
