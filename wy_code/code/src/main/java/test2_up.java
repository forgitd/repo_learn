/**
 * 作者：keboom
 * 链接：https://www.nowcoder.com/discuss/715131?channel=-1&source_id=discuss_terminal_discuss_sim_nctrack&ncTraceId=ceafabaec1ea42c783bb2eeb582eb0e5.275.16295974026957779
 * 来源：牛客网
 *
 * L1 = a L2 = b L3 = c ................. L26 = z
 * Si = Si-1 + Li + reverse(invert(Si-1))
 *
 * reverse 为翻转字符串，invert为反转每个字符比如a反转为z，b反转为y，c反转为x
 *
 * S1 = a S2 = a + b + z = abz
 *
 * S3 = abz + c + reverse(zya) = abzcayz
 *
 * .......................
 *
 * 输入n为Sn的意思，k为Sn字符串第k个字符
 */
public class test2_up {
    public char findKthBit(int n, int k) {
        // 动态规划，每一次生成字符串需要用到上一次生成的字符串
        // 使用一个字符串数组来记录这些字符串
        // si = si-1 + li + reverse(invert(si - 1))
        // dp, 动态规划 ()
        String[] dp = new String[n + 1];
        dp[1] = "a";
        for (int i = 2; i <= n; i++) {
            char Li = (char) ('a' + i - 1);
            dp[i] = dp[i - 1] + Li + reverse(invert(dp[i - 1]));
        }
        return dp[n].charAt(k - 1);

    }

    // StringBuilder 运行时，不安全，效率高
    public String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    // invert思路并不是置换 而是一个一个替换
    public String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 这里相互转换的两个字母 之和等于 z + a
            char res = (char) ('z' + 'a' - c);
            sb.append(res);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test2_up t2u = new test2_up();
        char res = t2u.findKthBit(4, 11);
        System.out.println(res);

    }
}
