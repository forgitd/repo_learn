import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int x,m;
            x = scanner.nextInt();
            m = scanner.nextInt();
            ArrayList<Integer> goods = new ArrayList<>();
//            for (Integer good : goods) {
//                good = scanner.nextInt();
//                goods.add(good);
//            }
            for (int i = 0; i < m; i++) {
                int good = scanner.nextInt();
                goods.add(good);
            }

            //  x 总价格 ， m 货物数量，   goods  所有商品的价格

            if (test2.t(goods,x) > 0) {
                System.out.println(test2.t(goods,x));
            }else {
                System.out.println(-1);
            }

        }

    }


    public static int t(ArrayList<Integer> g, int x) {
        int i = 0;
        int x1;
        if (g.contains(x)) {
            return i + 1;
        }
        int f = 1000;
        for (Integer i1 : g) {
            if (i1 < f) {
                f = i1;
            }
        }
        if (!g.contains(x) && x < f) {
            return 0;
        }
        for (Integer integer : g) {
            x1 = x - integer;
            g.remove(integer);
            return t(g ,x1) + i;
        }
        return i;
    }
}
