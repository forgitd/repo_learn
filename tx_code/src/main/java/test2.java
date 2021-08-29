import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[][] nums = new int[i][];;
        for (int j = 0; j < i; j++) {
            int m = scanner.nextInt();
            nums[j] = new int[m];
            for (int k = 0; k < m; k++) {
                nums[j][k] = scanner.nextInt();
            }
        }

        int[] f = new int[nums.length];
        for (int j = 0; j < i; j++) {
            Arrays.sort(nums[j]);
        }

        for (int j = 0; j < nums.length; j++) {
            for (int k = nums[j].length - 1; k >= 0 ; k--) {
                f[j] = f[j] + nums[j][k];
                for (int l = 0; l <= k - 1; l++) {
                    nums[j][l] = nums[j][l] + nums[j][k];
                }
            }
        }

        for (int i1 : f) {
            System.out.println(i1 % 1000000007);
        }
    }
}
