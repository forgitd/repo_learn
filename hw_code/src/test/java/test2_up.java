import java.util.ArrayList;
import java.util.Scanner;

/*
*   第一行：手中金钱为money，商品数量为n
    第二行：商品的价格表例如[3, 7, 5, 10, 5]
    *
    *
    * 模拟数据：
    * 25 5
    * 3 7 5 10 5
* */

public class test2_up {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int x,m;
            x = scanner.nextInt();
            m = scanner.nextInt();
            ArrayList<Integer> goods = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int i1 = scanner.nextInt();
                goods.add(i1);
            }

            System.out.println(t(goods, x));
        }
    }
    public static int t(ArrayList<Integer> goods, int x) {
        int[] dp = new int[x+1];
        dp[0] = 1;
        for (Integer good : goods) {
            for (int i = x; i >= good ; i--) {
                if (dp[i - good] != 0) {
                    dp[i] += dp[i - good];
                }
            }
        }
        return dp[x];
    }


}
